package org.example.back_end_functions;

import org.example.back_end_functions.functions_fixitems_processor.ValidateFiles;
import org.example.back_end_functions.functions_fixitems_processor.sub_functions.ActivatorCommandsReader;
import org.example.back_end_functions.functions_fixitems_processor.sub_functions.YamlFileLoader;
import org.example.global_assets.ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* Runs various steps to fix item configs
*/


public class FixItems_Processor extends Thread {

    public static ArrayList<String> validYmlFilePaths = new ArrayList<>(); // access this variable to modify the list of valid file paths

    private static void consoleLog(String value) {
        ConsoleWindow_Attributes.consoleWindowOutput.append(value+"\n");
        ConsoleWindow_Attributes.consoleWindowOutput.setCaretPosition(
                ConsoleWindow_Attributes.consoleWindowOutput.getDocument().getLength()
        );
    }

    @Override
    public void run() {
        try {
            // Calculating Runtime
            long start = System.currentTimeMillis();

            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_startMsg")); // START

            // Validate each file in the target directory to see which ones are valid
            ValidateFiles.executeTask();

            for (String validFilePath : validYmlFilePaths) {
                Map<String, Object> targetYamlFile = YamlFileLoader.getValidFile(validFilePath);
                ArrayList< List<String> > activatorCommands = ActivatorCommandsReader.executeTask(targetYamlFile);

                for (List<String> commandList : activatorCommands) {
                    for (String commands : commandList) {






                    }
                }
            }

            // Checking runtime duration
            long end = System.currentTimeMillis();
            NumberFormat formatter = new DecimalFormat("#0.00000");
            consoleLog("TASK DURATION: "+ formatter.format((end - start) / 1000d) + " seconds");

        } catch (Exception e) {
            consoleLog(String.valueOf(e.getStackTrace()));
        }
    }
}
