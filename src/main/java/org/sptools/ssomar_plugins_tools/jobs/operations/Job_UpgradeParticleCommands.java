package org.sptools.ssomar_plugins_tools.jobs.operations;

import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

import java.util.List;

public class Job_UpgradeParticleCommands {

    /**
     * The provided arguments may be null, which is why an if condition exists in the code.
     * It will mainly execute the {@link  Job_UpgradeParticleCommands#run(int, List)} function to do its job.
     * @param playerCommands
     * @param entityCommands
     * @param targetCommands
     * @param blockCommands
     */
    public Job_UpgradeParticleCommands(List<String> playerCommands, List<String> entityCommands, List<String> targetCommands, List<String> blockCommands) {

        ReusableFunctions.writeToConsole("Performing Job: UpgradeParticleCommands");

        if (playerCommands != null) {
            for (int iteration = 0; iteration < playerCommands.size(); iteration++) {
                run(iteration, playerCommands);
            }}

        if (entityCommands != null) {
            for (int iteration = 0; iteration < entityCommands.size(); iteration++) {
                run(iteration, entityCommands);
            }}

        if (targetCommands != null) {
            for (int iteration = 0; iteration < targetCommands.size(); iteration++) {
                run(iteration, targetCommands);
            }}

        if (blockCommands != null) {
            for (int iteration = 0; iteration < blockCommands.size(); iteration++) {
                run(iteration, blockCommands);
            }}
    }

    /**
     * It will read the command line word-by-word and uses the logic of changing states as it
     * reads words to perform some of the required detailed tasks.
     *
     * @param cmdLineIdx
     * @param listArg
     */
    private static void run(int cmdLineIdx, List<String> listArg) {
        String[] commandLineChopped = listArg.get(cmdLineIdx).split(" ");

        int modifiedParticleCommands = 0; // for counting

        StringBuilder strBuilder = new StringBuilder();

        /**
         * Helps the code know how to format incoming word reads.
         * For example, the dust particle type and the block particle type has different arguments,
         * meaning, the code has to convert formats differently.
         */
        String gatherType = "";
        int iteration = 0;
        boolean isInspectingParticleType = false;
        boolean isGatheringData = false; // for knowing whether to start recording data differently or not

        for (String word : commandLineChopped) {
            if (word.equals("particle") || word.equals("minecraft:particle")) {
                //System.out.println("anchor found");
                strBuilder.append(" ").append(word);
                isInspectingParticleType = true;
                continue;
            }

            if (isInspectingParticleType && (word.equals("dust") || word.equals("minecraft:dust"))) {
                //System.out.println("anchor start");
                strBuilder.append(" ").append(word);
                gatherType = "dust";
                isGatheringData = true;
                modifiedParticleCommands += 1;
                continue;
            }

            if (!isGatheringData) {
                strBuilder.append(" ").append(word);
                continue;
            }

            if (gatherType.equals("dust")) {
                switch (iteration) {
                    case 0: {
                        strBuilder.append("{color:[").append(Float.valueOf(word));
                        iteration += 1;
                        continue;
                    }
                    case 1: {
                        strBuilder.append(",").append(Float.valueOf(word));
                        iteration += 1;
                        continue;
                    }
                    case 2: {
                        strBuilder.append(",").append(Float.valueOf(word)).append("],scale:");
                        iteration += 1;
                        continue;
                    }
                    case 3: {
                        strBuilder.append(Float.valueOf(word)).append("}");
                        iteration = 0;
                        isGatheringData = false;
                        isInspectingParticleType = false;
                        //System.out.println("anchor end");
                        continue;
                    }
                }
            }


        }


        ReusableFunctions.writeToConsole(("    Applied "+modifiedParticleCommands+" word changes to this command."));

        strBuilder.deleteCharAt(0); // removing unwanted whitespace
        listArg.set(cmdLineIdx, strBuilder.toString());
    }


}
