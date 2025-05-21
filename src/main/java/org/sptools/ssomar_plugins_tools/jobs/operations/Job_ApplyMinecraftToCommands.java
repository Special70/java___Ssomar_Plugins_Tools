package org.sptools.ssomar_plugins_tools.jobs.operations;

import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

import java.util.List;
import java.util.Set;


public class Job_ApplyMinecraftToCommands {

    /**
     * The provided arguments may be null, which is why an if condition exists in the code.
     * It will mainly execute the {@link  Job_ApplyMinecraftToCommands#run(int, List)} function to do its job.
     * @param playerCommands
     * @param entityCommands
     * @param targetCommands
     * @param blockCommands
     */
    public Job_ApplyMinecraftToCommands(List<String> playerCommands, List<String> entityCommands, List<String> targetCommands, List<String> blockCommands) {

        ReusableFunctions.writeToConsole("Performing Job: ApplyMinecraftToCommands");

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

    Set<String> targetWords = Set.of(
            "ability","advancement","alwaysday","attribute","ban","ban-ip","banlist","bossbar",
            "camera","camerashake","changesetting","clear","clearspawnpoint","clone","connect",
            "damage","data","datapack","daylock","debug","dedicatedwsserver","defaultgamemode",
            "deop","dialogue","difficulty","effect","enchant","event","execute","experience",
            "fill","fillbiome","fog","forceload","function","gamemode","gamerule","gametest",
            "give","help","immutableworld","item","jfr","kick","kill","list","locate","loot",
            "me","mobevent","msg","music","op","ops","pardon","pardon-ip","particle","perf",
            "permission","place","playanimation","playsound","publish","random","recipe","reload",
            "remove","replaceitem","return","ride","save","save-all","save-off","save-on","say",
            "schedule","scoreboard","script","scriptevent","seed","setblock","setidletimeout",
            "setmaxplayers","setworldspawn","spawnpoint","spectate","spreadplayers","stop","stopsound",
            "structure","summon","tag","team","teammsg","teleport","tell","tellraw","testfor","testforblock",
            "testforblocks","tickingarea","time","tick","title","titleraw","tm","toggledownfall","tp",
            "trigger","transferserver","volumearea","w","wb","weather","whitelist","worldborder",
            "worldbuilder","wsserver","xp");

    /**
     * Applies the "minecraft:" label to specify minecraft commands. Since 1.13, ExecutableItems ei item configurations
     * started to break because previous configurations heavily relied on vanilla commands and server owners may have
     * plugins installed that overrides the vanilla commands.
     *
     * @param cmdLineIdx used to point towards the correct line in the list
     * @param listArg pointer to access the command list and to be able to use the .set() method to apply the changes
     */
    private void run(int cmdLineIdx, List<String> listArg) {
        String[] commandLineChopped = listArg.get(cmdLineIdx).split(" ");

        int signedCommands = 0; // for counting

        StringBuilder strBuilder = new StringBuilder();
        boolean doSkip = false; // this logic was added due to how there can be commands written as "effect give".
        for (String word : commandLineChopped) {
            if (targetWords.contains(word) && !doSkip) {
                strBuilder.append(" minecraft:"+word);
                signedCommands++;
                doSkip = true;
            }
            else {
                doSkip = false;
                strBuilder.append(" "+word);
            }
        }
        strBuilder.deleteCharAt(0); // removes the unwanted whitespace at the start

        // Applies the changes to the target command
        listArg.set(cmdLineIdx, String.valueOf(strBuilder));

        ReusableFunctions.writeToConsole(("    Applied "+signedCommands+" word changes to this command."));

    }





}
