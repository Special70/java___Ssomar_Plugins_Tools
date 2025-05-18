package org.sptools.ssomar_plugins_tools.jobs;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import org.sptools.ssomar_plugins_tools.controllers.ConsoleWindowController;
import org.sptools.ssomar_plugins_tools.lib.LibClass;

import java.io.IOException;

public class JobHandler {

    private static LibClass libClass = new LibClass();

    /**
     * External classes have to be the one to modify this value so the JobClass class would know which
     * instance of the Control object needs to be touched to apply changes to the console.
     */
    public static TextArea outputFieldPointer;

    public static void start(String[] params) throws IOException {

        Thread thread = new Thread(()->{
            outputFieldPointer.appendText("test");
        });
        thread.setDaemon(true);
        thread.start();
    }
}
