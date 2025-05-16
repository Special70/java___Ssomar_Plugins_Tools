package org.sptools.ssomar_plugins_tools.jobs;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import org.sptools.ssomar_plugins_tools.controllers.ConsoleWindowController;
import org.sptools.ssomar_plugins_tools.lib.LibClass;

import java.io.IOException;

public class JobHandler {

    private static LibClass libClass = new LibClass();

    TextArea outputArea;

    public static void start(String[] params) throws IOException {

        Thread thread = new Thread(()->{
            //controller.outputScreen.appendText("wuwa");

        });
        thread.setDaemon(true);
        thread.start();
    }
}
