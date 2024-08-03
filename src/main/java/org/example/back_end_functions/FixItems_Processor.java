package org.example.back_end_functions;

import org.example.back_end_functions.functions_fixitems_processor.ConvertDustCMDTo_1_20_5;
import org.example.back_end_functions.functions_fixitems_processor.FixTPCommand;
import org.example.back_end_functions.functions_fixitems_processor.ValidateFiles;
import org.example.panels.childs_mainframe.Selection_Functions;
import org.example.global_assets.ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

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

            ValidateFiles.executeTask();

            if (Selection_Functions.button_fixTPCommand.isSelected()) {
                FixTPCommand.executeTask();
            }

            if (Selection_Functions.button_convertDustCommandsTo_1_20_5.isSelected()) {
                ConvertDustCMDTo_1_20_5.executeTask();
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
