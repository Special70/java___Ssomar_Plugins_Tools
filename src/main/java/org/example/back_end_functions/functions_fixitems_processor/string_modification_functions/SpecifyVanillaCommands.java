package org.example.back_end_functions.functions_fixitems_processor.string_modification_functions;

import org.example.back_end_functions.FixItems_Processor;
import org.example.global_assets.ConsoleWindow;
import org.example.global_assets.ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class SpecifyVanillaCommands {
    public static void executeTask() {

        try {
            ConsoleWindow.log(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_startMsg"));
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
                ConsoleWindow.log(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_startEditing").replace("%path%", path));
                    // Counts the number of pattern counts in the target file
                    long numberOfPatternsFound_tp = Pattern.compile("(?<![\\w:])tp").matcher(contentOfTheTargetfile).results().count();
                    long numberOfPatternsFound_kill = Pattern.compile("(?<![\\w:])kill").matcher(contentOfTheTargetfile).results().count();

                    // Checks if instances are detected. Otherwise, skip writing
                    if (numberOfPatternsFound_tp <= 0) {
                        ConsoleWindow.log(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_count_tp_commands_Msg")
                                .replace("%count%", String.valueOf(0))
                                .replace("%skip%","SKIPPING!")
                        );
                        continue;
                    }

                    ConsoleWindow.log(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_count_tp_commands_Msg")
                        .replace("%count%", String.valueOf(
                                numberOfPatternsFound_tp+
                                numberOfPatternsFound_kill))
                        .replace("%skip%","")
                    );
                    // Starts writing the new version to the target file

                    // It's very easy to add more commands to watch out for here
                    String itemFileConfigurationTextHolder = contentOfTheTargetfile.toString()
                            .replaceAll("(?<![\\w:])tp","minecraft:tp")
                            .replaceAll("(?<![\\w:])kill","minecraft:kill");
                    FileWriter fileWriter = new FileWriter(path);
                    for (int iteration = 0; iteration < itemFileConfigurationTextHolder.length(); iteration++) {
                        fileWriter.write(itemFileConfigurationTextHolder.charAt(iteration));
                    }
                ConsoleWindow.log(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_endEditing").replace("%path%", path));
                    fileWriter.close();



            }

            ConsoleWindow.log(Resource_Lang.langFile.getProperty("FixItems_Processor_SpecifyVanillaCommands_endMsg"));
        } catch (Exception e) {

        }
    }
}
