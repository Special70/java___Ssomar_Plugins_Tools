package org.sptools.ssomar_plugins_tools.jobs.operations;

import org.sptools.ssomar_plugins_tools.jobs.BaseJobOperation;
import org.sptools.ssomar_plugins_tools.jobs.operations.suboperations.upgradeparticlecommands.DustParticleConvert;
import org.sptools.ssomar_plugins_tools.jobs.operations.suboperations.upgradeparticlecommands.ItemParticleConvert;
import org.sptools.ssomar_plugins_tools.jobs.utility.JobState;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

import java.util.List;
import java.util.Set;

public class Job_UpgradeParticleCommands extends BaseJobOperation {


    public Job_UpgradeParticleCommands(List<String> playerCommands, List<String> entityCommands, List<String> targetCommands, List<String> blockCommands) {
        super(playerCommands, entityCommands, targetCommands, blockCommands);
    }

    /**
     * It will read the command line word-by-word and uses the logic of changing states as it
     * reads words to perform some of the required detailed tasks.
     *
     * @param cmdLineIdx
     * @param listArg
     */
    @Override
    public void run(int cmdLineIdx, List<String> listArg) {
        // only list particle types that are supported as of now
        final Set<String> targetParticleTypes = Set.of("dust","item");
        StringBuilder strBuilder = new StringBuilder();

        String[] commandLineChopped = listArg.get(cmdLineIdx).split(" ");
        int modifiedParticleCommands = 0; // for counting

        JobState jobState = new JobState();

        for (String word : commandLineChopped) {
            if (word.equals("particle") || word.equals("minecraft:particle")) {
                //System.out.println("anchor found");
                strBuilder.append(" ").append(word);
                jobState.isInspectingParticleType = true;
                continue;
            }

            // get the gather type here through reading what particle type goes after the word "particle"
            if (jobState.isInspectingParticleType && targetParticleTypes.contains(word) || targetParticleTypes.contains("minecraft:"+word)) {

                strBuilder.append(" ").append(word);
                jobState.gatherType = word.replace("minecraft:".toLowerCase(),""); // clean the minecraft: field since it's unneeded
                jobState.isGatheringData = true;
                modifiedParticleCommands += 1;
                continue;
            }

            if (!jobState.isGatheringData) {
                strBuilder.append(" ").append(word);
                continue;
            }


            switch (jobState.gatherType) {
                case "dust": {
                    DustParticleConvert.run(jobState, strBuilder, word);
                    break;
                }
                case "item": {
                    ItemParticleConvert.run(jobState, strBuilder, word);
                    break;
                }
            }


        }

        if (modifiedParticleCommands > 0) ReusableFunctions.writeToConsole(("    Applied "+modifiedParticleCommands+" word changes to this command."));

        strBuilder.deleteCharAt(0); // removing unwanted whitespace
        listArg.set(cmdLineIdx, strBuilder.toString());
    }



}
