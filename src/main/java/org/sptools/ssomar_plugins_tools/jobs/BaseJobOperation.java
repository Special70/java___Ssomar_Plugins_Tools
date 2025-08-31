package org.sptools.ssomar_plugins_tools.jobs;

import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

import java.util.List;

public abstract class BaseJobOperation {

    /**
     * The provided arguments may be null, which is why an if condition exists in the code.
     * It will mainly execute the {@link  BaseJobOperation#run(int, List)} function to do its job.
     * @param playerCommands
     * @param entityCommands
     * @param targetCommands
     * @param blockCommands
     */
    public BaseJobOperation(List<String> playerCommands, List<String> entityCommands, List<String> targetCommands, List<String> blockCommands) {

        ReusableFunctions.writeToConsole("Performing Job: "+this.getClass().getSimpleName());

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

    public abstract void run(int cmdLineIdx, List<String> listArg);
}
