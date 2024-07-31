package org.example.back_end_functions;

import org.example.back_end_functions.functions_fixitems_processor.FixTPCommand;
import org.example.back_end_functions.functions_fixitems_processor.ValidateFiles;
import org.example.panels.childs_mainframe.Selection_Functions;
import org.example.panels.childs_mainframe.childs_fixitemsui.FixItemsUI_ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import java.util.ArrayList;

/*
* Runs various steps to fix item configs
*/


public class FixItems_Processor extends Thread {
    public static FixItems_Processor staticObj = new FixItems_Processor();

    public static ArrayList<String> validYmlFilePaths = new ArrayList<>();

    private static void consoleLog(String value) {
        FixItemsUI_ConsoleWindow_Attributes.consoleWindowOutput.append(value+"\n");
        FixItemsUI_ConsoleWindow_Attributes.consoleWindowOutput.setCaretPosition(
                FixItemsUI_ConsoleWindow_Attributes.consoleWindowOutput.getDocument().getLength()
        );
    }
    @Override
    public void run() {
        try {
            consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_startMsg")); // START

            ValidateFiles.executeTask();

            if (Selection_Functions.button_fixTPCommand.isSelected()) {

                FixTPCommand.executeTask();
            }









        } catch (Exception e) {
            consoleLog(String.valueOf(e.getStackTrace()));
        }




    }
}
