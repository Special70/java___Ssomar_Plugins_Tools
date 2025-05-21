package org.sptools.ssomar_plugins_tools.jobs;

import org.sptools.ssomar_plugins_tools.jobs.operations.Job_ApplyMinecraftToCommands;
import org.sptools.ssomar_plugins_tools.jobs.operations.Job_DowngradeParticleCommands;
import org.sptools.ssomar_plugins_tools.jobs.operations.Job_UpgradeParticleCommands;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;
import org.sptools.ssomar_plugins_tools.lib.functions.YamlFileLoader;
import org.sptools.ssomar_plugins_tools.lib.functions.YamlFileSaver;
import org.sptools.ssomar_plugins_tools.system.SystemVariables;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class helps job classes to access commands. But
 * the core purpose of this class is to host the code that
 * iterates through each valid yml file so the job methods are executed instead
 * and to avoid code duplication.
 */
public class JobHelper_AccessCommands {

    /**
     * The params provided to {@link JobHandler} will be used to analyze which job gets executed.
     */
    private static ArrayList<String> paramJobs;
    public static void setParamJobs(ArrayList<String> params) {
        paramJobs = params;
    }

    /**
     * Starts accessing the commands section of the item configs
     */
    public JobHelper_AccessCommands(ArrayList<String> paramArgs) {
        Thread thread = new Thread(() -> {
            try {
                setParamJobs(paramArgs);
                run();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * This iterates through all gathered valid yml's file paths, then load them as a Map datatype.
     * It will then visit the children of the key "activators".
     */
    private void run() throws FileNotFoundException {

        for (String filePath : SystemVariables.validYMLFilesPaths) {

            ReusableFunctions.writeToConsole(("Initiating job at file: "+filePath));

            Map<String, Object> loadedYMLFile = YamlFileLoader.getValidFile(filePath);

            // Navigate to the "commands" list
            Map<String, Object> activators = (Map<String, Object>) loadedYMLFile.get("activators"); // gets the properties of the "activators:" to get the child objects (activator0, activator1, ...)

            // iterates through its child objects
            for (Map.Entry<String, Object> foundActivators : activators.entrySet()) {
                ReusableFunctions.writeToConsole(("  Traversing to activator: "+foundActivators.getKey()));
                run2(foundActivators, activators);
            }

            ReusableFunctions.writeToConsole("Start saving changes");
            YamlFileSaver.saveChanges(filePath, loadedYMLFile);
        }

        ReusableFunctions.writeToConsole("Job Finished");
    }

    /**
     * While it's at the children of the "activators" key, it will then start to visit the commands, which will be edited.
     *
     * To perform the job, each command line will be separated via whitespace so each word in the command line would be inspected.
     */
    private void run2(Map.Entry<String, Object> foundActivators, Map<String, Object> activators) {
        Map<String, Object> targetActivator = (Map<String, Object>) activators.get(foundActivators.getKey()); // saves the child object in a variable
        List<String> playerCommands = (List<String>) targetActivator.get("commands");
        List<String> entityCommands = (List<String>) targetActivator.get("entityCommands");
        List<String> targetCommands = (List<String>) targetActivator.get("targetCommands");
        List<String> blockCommands = (List<String>) targetActivator.get("blockCommands");

        if (paramJobs.contains("job-1.0")) {
            new Job_ApplyMinecraftToCommands(playerCommands, entityCommands, targetCommands, blockCommands);
        }
        if (paramJobs.contains("job-2.0")) {
            new Job_UpgradeParticleCommands(playerCommands, entityCommands, targetCommands, blockCommands);
        }
        if (paramJobs.contains("job-2.1")) {
            new Job_DowngradeParticleCommands(playerCommands, entityCommands, targetCommands, blockCommands);
        }

    }
}
