package org.sptools.ssomar_plugins_tools.jobs.operations;

import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

import java.util.Arrays;
import java.util.List;

public class Job_DowngradeParticleCommands {

    /**
     * The provided arguments may be null, which is why an if condition exists in the code.
     * It will mainly execute the {@link  Job_DowngradeParticleCommands#run(int, List)} function to do its job.
     * @param playerCommands
     * @param entityCommands
     * @param targetCommands
     * @param blockCommands
     */
    public Job_DowngradeParticleCommands(List<String> playerCommands, List<String> entityCommands, List<String> targetCommands, List<String> blockCommands) {

        ReusableFunctions.writeToConsole("Performing Job: DownParticleCommands");

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
        boolean isInspectingParticleType = false;
        boolean isGatheringData = false; // for knowing whether to start recording data differently or not

        for (String word : commandLineChopped) {
            //System.out.println("Investigating : "+ word);
            if ( word.equals("particle") || word.equals("minecraft:particle")) {
                //System.out.println("anchor found");
                strBuilder.append(" ").append(word);
                isInspectingParticleType = true;
                continue;
            }

            if (isInspectingParticleType && ((word.contains("dust") || word.contains("minecraft:dust")))) {

                // config fixer MAY encounter actually downgraded particle commands
                if (!word.contains("{")) {
                    //System.out.println("anchor invalid.");
                    isInspectingParticleType = false;
                    continue;

                }

                //System.out.println("anchor start");
                modifiedParticleCommands += 1;

                String[] textToModify = word
                        .replace("minecraft:dust", "")
                        .replace("dust","")
                        .replace("{color:[", "")
                        .replace("],scale:", ",")
                        .replace("}","").split(",")
                        ; // shave off the details

                //System.out.println(word);
                String dust = " dust" +
                        " " + textToModify[0] +
                        " " + textToModify[1] +
                        " " + textToModify[2] +
                        " " + textToModify[3];

                strBuilder.append(dust);
                isInspectingParticleType = false;
                continue;
            }

            strBuilder.append(" ").append(word);




        }

        ReusableFunctions.writeToConsole(("    Applied "+modifiedParticleCommands+" word changes to this command."));

        strBuilder.deleteCharAt(0); // removing unwanted whitespace
        listArg.set(cmdLineIdx, strBuilder.toString());
    }
}
