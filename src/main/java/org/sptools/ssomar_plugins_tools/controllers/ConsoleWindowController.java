package org.sptools.ssomar_plugins_tools.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;
import org.sptools.ssomar_plugins_tools.system.SystemVariables;

import java.io.IOException;


public class ConsoleWindowController {



    @FXML
    public TextArea outputScreen;

    @FXML
    public Button backButton;

    @FXML
    public void backToPreviousMenu(ActionEvent event) throws IOException {
        ReusableFunctions.switchMenu(event, getClass(), SystemVariables.previousMenuPath);

    }


}
