package org.example.back_end_functions.functions_fixitems_processor;

import org.example.back_end_functions.FixItems_Processor;
import org.example.global_assets.ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_GlobalVariables;
import org.example.resource_loader_functions.Resource_Lang;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidateFiles {
    private static void consoleLog(String value) {
        ConsoleWindow_Attributes.consoleWindowOutput.append(value+"\n");
        ConsoleWindow_Attributes.consoleWindowOutput.setCaretPosition(
                ConsoleWindow_Attributes.consoleWindowOutput.getDocument().getLength()
        );
    }
    public static void executeTask() {
        try {
            // consoleLog() : adds text to the jtextarea in FixItemsUI_ConsoleWindow_Attributes
            ArrayList<String> recordsOfValidYMLFiles = new ArrayList<>(); // To be transferred later

            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ValidateFiles_startMsg"));

            File selectedDir = new File(Resource_GlobalVariables.selectedFilePath);
            File[] directoryListing = selectedDir.listFiles();

            if (directoryListing != null) {
                for (File childFile : directoryListing) {


                    if (Pattern.compile(".*\\.(yml)").matcher(childFile.getPath()).find())
                    // If the target file is really a YML file (by checking if the file path ends with ".yml")
                    {
                        Yaml yaml = new Yaml();
                        try (InputStream inputStream = new FileInputStream(childFile.getPath())) {
                            Map<String, Object> data = yaml.load(inputStream);
                            String dummy = String.valueOf(data); // The purpose of this variable is for the program to try to touch the loaded file and see if any issues trigger

                            // The code continues if the file is valid

                            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ValidateFiles_validationSuccessMsg").replaceAll("%path%", childFile.getPath().replace("\\","/")));
                            recordsOfValidYMLFiles.add(childFile.getPath());

                        } catch (Exception yamlValidationError) {
                            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ValidateFiles_validationErrorMsg"));
                            consoleLog("ERROR PATH: "+childFile.getPath());


                            StringWriter sw = new StringWriter();
                            PrintWriter pw = new PrintWriter(sw);
                            yamlValidationError.printStackTrace(pw);
                            String sStackTrace = sw.toString();
                            consoleLog(sStackTrace);
                        }
                    }


                }
            }

            FixItems_Processor.validYmlFilePaths = recordsOfValidYMLFiles;
            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ValidateFiles_endMsg"));


        } catch (Exception e) {
            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ValidateFiles_crashMsg"));
            consoleLog(String.valueOf(e.getStackTrace()));
        }
    }
}
