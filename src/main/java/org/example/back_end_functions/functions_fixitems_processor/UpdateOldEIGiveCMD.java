package org.example.back_end_functions.functions_fixitems_processor;

import org.example.back_end_functions.FixItems_Processor;
import org.example.global_assets.ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <h1>WIP : DO NOT FULLY USE YET!</h1>
 */
public class UpdateOldEIGiveCMD {

    private static void consoleLog(String value) {
        ConsoleWindow_Attributes.consoleWindowOutput.append(value+"\n");
        ConsoleWindow_Attributes.consoleWindowOutput.setCaretPosition(
                ConsoleWindow_Attributes.consoleWindowOutput.getDocument().getLength()
        );
    }

    /**
     * How this works: after using a for loop to iterate through the key  to access the child keys,
     * it will specifically target its child key: "commands" which is the target for the replacement.
     * For every command line (element of an array), it will count the amount of dust commands found that needs correction.
     * If no pattern was found, SKIP job. Otherwise, continue.
     *
     */
    public static void executeTask() {

        // BIG O Formula = number_of_validated_files * number_of_activators (typically 1-5) * number_of_commands (typically 10-200)

        try {
            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ConvertDustCMDTo_1_20_5_startMsg"));

            // Iterates through valid yml files
            for (String path : FixItems_Processor.validYmlFilePaths) {

                // Reading yml files and saving it in a Map
                InputStream inputStream = new FileInputStream(new File(path));
                Yaml yaml = new Yaml();
                Map<String, Object> loadedYMLFile = yaml.load(inputStream);
                // Done reading the entire file and loading it as YML

                // Navigate to the "commands" list
                Map<String, Object> activators = (Map<String, Object>) loadedYMLFile.get("activators"); // gets the properties of the "activators:" to get the child objects (activator0, activator1, ...)

                // For saving the amount of patterns found (for logging purposes)
                int foundPatternCount = 0;

                // iterates through its child objects
                for (Map.Entry<String, Object> foundActivators : activators.entrySet()) {

                    Map<String, Object> targetActivator = (Map<String, Object>) activators.get(foundActivators.getKey()); // saves the child object in a variable
                    List<String> commandsOfTheActivator = (List<String>) targetActivator.get("commands"); // saves the command list of the child object to this variable

                    for (int iterations = 0; iterations < commandsOfTheActivator.size(); iterations++) {
                        Set<String> foundPatterns = new HashSet<>(); // Store found patterns here (HashSet is used here to not store duplicates because its useless)

                        // Mainly to properly catch patterns of (dust <double> <double> <double> <double>)
                        Matcher matchFinder = Pattern.compile("ei\\s+(giveslot|give)\\s+[%\\w]+\\s+[%\\w]+\\s+\\d+\\s+[%\\w]+\\s+[VARUSAGEvarusage]+(\\(.*\\))")
                                .matcher(commandsOfTheActivator.get(iterations));

                        // Adds the found patterns here
                        while (matchFinder.find()) {
                            foundPatterns.add(matchFinder.group().trim());
                        }

                        foundPatternCount += foundPatterns.size();

                        // Skipping the steps below if no patterns are found ==================================================================================================================================================
                        if (foundPatterns.isEmpty()) {
                            continue;
                        }

                        consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ConvertDustCMDTo_1_20_5_startEditing").replace("%path%", path));

                        // Start replacing every found pattern
                        for (String foundPattern : foundPatterns) {

                            // Store the detected patterns into an array for further use
                            String[] patternDetails = foundPattern.split(" ");

                            // Converts the other values into double
                            double[] rgbSizeParameters = new double[]{
                                    Double.parseDouble(patternDetails[1]),
                                    Double.parseDouble(patternDetails[2]),
                                    Double.parseDouble(patternDetails[3]),
                                    Double.parseDouble(patternDetails[4])
                            };

                            String newParticleDustCommandFormat = (
                                    "dust{color:[" +
                                            rgbSizeParameters[0] + "," +
                                            rgbSizeParameters[1] + "," +
                                            rgbSizeParameters[2] +
                                            "],scale:" + rgbSizeParameters[3] + "}"
                            );

                            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ConvertDustCMDTo_1_20_5_commenceReplacingMsg")
                                    .replace("%old%", foundPattern)
                                    .replace("%new%", newParticleDustCommandFormat));

                            // Applies the changes to the target command
                            commandsOfTheActivator.set(iterations, commandsOfTheActivator.get(iterations).replace(foundPattern, newParticleDustCommandFormat));

                        }


                    }

                }
                // Done making changes inside the yaml file

                consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ConvertDustCMDTo_1_20_5_patternCountInAFile")
                        .replace("%count%", String.valueOf(foundPatternCount))
                        .replace("%path%", path)
                );

                // Sets up the correct settings so when pasting the data in a yml file, array-type key-value pairs would be listed with "-" symbols instead of ","
                DumperOptions options = new DumperOptions();
                options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
                Yaml yamlDumper = new Yaml(options);

                // Write the modified data back to the YAML file
                FileWriter writer = new FileWriter(new File(path)); // Replaces the current file
                yamlDumper.dump(loadedYMLFile, writer);
                // Done
                consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ConvertDustCMDTo_1_20_5_endEditing").replace("%path%", path));
            }

            // Prints to console indicating that the job is complete
            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ConvertDustCMDTo_1_20_5_endMsg"));
        } catch (Exception e) {

        }
    }
}
