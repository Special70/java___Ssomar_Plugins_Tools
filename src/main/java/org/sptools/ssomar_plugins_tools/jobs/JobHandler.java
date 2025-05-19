package org.sptools.ssomar_plugins_tools.jobs;

import javafx.scene.control.TextArea;
import org.sptools.ssomar_plugins_tools.lib.LibClass;
import org.sptools.ssomar_plugins_tools.lib.functions.ValidateYMLFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/**
 * The central class for the program's job operations.
 * Subclasses would be labeled as "JobHelper".
 * Operation classes will be at the operations package.
 */
public class JobHandler {

    public static void start(ArrayList<String> params) throws IOException {

        Thread thread = new Thread(()->{
            // find valid files to be edited by the program
            ValidateYMLFiles.executeTask();

            // for options that involve modifying commands:
            new JobHelper_AccessCommands(params);
        });
        thread.setDaemon(true);
        thread.start();
    }
}
