package org.example.back_end_functions.functions_fixitems_processor.instructions;

import org.example.back_end_functions.FixItems_Processor;
import org.example.global_assets.ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class SpecifyVanillaCommands {
    private static void consoleLog(String value) {
        ConsoleWindow_Attributes.consoleWindowOutput.append(value+"\n");
        ConsoleWindow_Attributes.consoleWindowOutput.setCaretPosition(
                ConsoleWindow_Attributes.consoleWindowOutput.getDocument().getLength()
        );
    }
    public static void executeTask() {

        try {
            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_startMsg"));
            // Iterates through all found valid yml files
            for (String path : FixItems_Processor.validYmlFilePaths) {
                BufferedReader reader = Files.newBufferedReader(Paths.get(path));
                StringBuilder contentOfTheTargetfile = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    contentOfTheTargetfile.append(line);
                    contentOfTheTargetfile.append(System.lineSeparator());
                }

                // Starts editing the file
                consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_startEditing").replace("%path%", path));
                    // Counts the number of pattern counts in the target file
                    long numberOfPatternsFound_tp = Pattern.compile("(?<!:)tp").matcher(contentOfTheTargetfile).results().count();
                    long numberOfPatternsFound_kill = Pattern.compile("(?<!:)kill").matcher(contentOfTheTargetfile).results().count();

                    // Checks if instances are detected. Otherwise, skip writing
                    if (numberOfPatternsFound_tp <= 0) {
                        consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_count_tp_commands_Msg")
                                .replace("%count%", String.valueOf(0))
                                .replace("%skip%","SKIPPING!")
                        );
                        continue;
                    }

                    consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_count_tp_commands_Msg")
                        .replace("%count%", String.valueOf(
                                numberOfPatternsFound_tp+
                                numberOfPatternsFound_kill))
                        .replace("%skip%","")
                    );
                    // Starts writing the new version to the target file

                    // It's very easy to add more commands to watch out for here
                    String itemFileConfigurationTextHolder = contentOfTheTargetfile.toString()
                            .replaceAll("(?<!:)tp","minecraft:tp")
                            .replaceAll("(?<!:)kill","minecraft:kill");
                    FileWriter fileWriter = new FileWriter(path);
                    for (int iteration = 0; iteration < itemFileConfigurationTextHolder.length(); iteration++) {
                        fileWriter.write(itemFileConfigurationTextHolder.charAt(iteration));
                    }
                consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_endEditing").replace("%path%", path));
                    fileWriter.close();



            }

            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_endMsg"));
        } catch (Exception e) {

        }
    }
}
