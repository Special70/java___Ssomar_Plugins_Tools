package org.example.back_end_functions.functions_fixitems_processor;

import org.example.back_end_functions.FixItems_Processor;
import org.example.panels.childs_mainframe.childs_fixitemsui.FixItemsUI_ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class FixTPCommand {
    private static void consoleLog(String value) {
        FixItemsUI_ConsoleWindow_Attributes.consoleWindowOutput.append(value+"\n");
        FixItemsUI_ConsoleWindow_Attributes.consoleWindowOutput.setCaretPosition(
                FixItemsUI_ConsoleWindow_Attributes.consoleWindowOutput.getDocument().getLength()
        );
    }
    public static void executeTask() {

        try {
            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_FixTPCommand_startMsg"));
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
                consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_FixTPCommand_startEditing").replace("%path%", path));
                    // Counts the number of instances found (replaces "%count%" with a regex that searches using "(?<!minecraft:)tp)
                    long numberOfPatternsFound = Pattern.compile("(?<!minecraft:)tp").matcher(contentOfTheTargetfile).results().count();

                    // Checks if instances are detected. Otherwise, skip writing
                    if (numberOfPatternsFound <= 0) {
                        consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_FixTPCommand_countPatternsMsg")
                                .replace("%count%", String.valueOf(numberOfPatternsFound))
                                .replace("%skip%","SKIPPING!")
                        );
                        continue;
                    }

                    consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_FixTPCommand_countPatternsMsg")
                        .replace("%count%", String.valueOf(numberOfPatternsFound))
                        .replace("%skip%","")
                    );
                // Starts writing the new version to the target file
                    String itemFileConfigurationTextHolder = contentOfTheTargetfile.toString().replaceAll("(?<!minecraft:)tp","minecraft:tp");
                    FileWriter fileWriter = new FileWriter(path);
                    for (int iteration = 0; iteration < itemFileConfigurationTextHolder.length(); iteration++) {
                        fileWriter.write(itemFileConfigurationTextHolder.charAt(iteration));
                    }
                consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_FixTPCommand_endEditing").replace("%path%", path));
                    fileWriter.close();



            }

            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_FixTPCommand_endMsg"));
        } catch (Exception e) {

        }
    }
}
