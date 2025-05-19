package org.sptools.ssomar_plugins_tools.lib.functions;

import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;
import org.sptools.ssomar_plugins_tools.system.SystemVariables;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidateYMLFiles {


    public static void executeTask() {
        try {
            // consoleLog() : adds text to the jtextarea in FixItemsUI_ConsoleWindow_Attributes
            ArrayList<String> recordsOfValidYMLFiles = new ArrayList<>(); // To be transferred later


            File selectedDir = new File(SystemVariables.selectedDirectory);
            File[] directoryListing = selectedDir.listFiles();

            // stop operation if there are no found files
            if (directoryListing == null) {return;}

            for (File childFile : directoryListing) {

                // skip loop if the file type isn't .yml
                if (!Pattern.compile(".*\\.(yml)").matcher(childFile.getPath()).find()) {continue;}

                Yaml yaml = new Yaml();

                // attempt to see if file is valid
                try (InputStream inputStream = new FileInputStream(childFile.getPath())) {
                    Map<String, Object> data = yaml.load(inputStream);
                    String dummy = String.valueOf(data); // The purpose of this variable is for the program to try to touch the loaded file and see if any issues trigger

                    // The code continues if the file is valid
                    recordsOfValidYMLFiles.add(childFile.getPath());

                }

                catch (Exception yamlValidationError) {
                    ReusableFunctions.writeToConsole("ERROR PATH: " + childFile.getPath());

                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    yamlValidationError.printStackTrace(pw);
                    String sStackTrace = sw.toString();
                    ReusableFunctions.writeToConsole(sStackTrace);
                }



            }


            SystemVariables.validYMLFilesPaths = recordsOfValidYMLFiles;
            ReusableFunctions.writeToConsole("Done Verifying files");


        } catch (Exception e) {
            ReusableFunctions.writeToConsole("A crash has occured while verifying yml files");
        }
    }
}
