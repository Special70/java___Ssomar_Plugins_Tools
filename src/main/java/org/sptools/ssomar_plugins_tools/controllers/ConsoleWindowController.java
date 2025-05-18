package org.sptools.ssomar_plugins_tools.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.sptools.ssomar_plugins_tools.jobs.JobHandler;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;
import org.sptools.ssomar_plugins_tools.system.SystemVariables;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ConsoleWindowController implements Initializable {


    /**
     * Various classes will try to edit this variable to be able to print outputs.
     * But to be able to access it, the class instance itself has to be the one
     * giving out the pointer themselves. See {@link ConsoleWindowController#initialize(URL, ResourceBundle)}
     */
    @FXML
    public TextArea outputScreen;

    @FXML
    public Button backButton;

    /**
     * ConsoleWindowController may be used a lot by other places in this code. For the sake
     * of the future and for habits, {@link SystemVariables#previousMenuPath} is created to be able to
     * let the program know where was the user previously.
     */
    @FXML
    public void backToPreviousMenu(ActionEvent event) throws IOException {
        ReusableFunctions.switchMenu(event, getClass(), SystemVariables.previousMenuPath);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JobHandler.outputFieldPointer = this.outputScreen;
    }
}
