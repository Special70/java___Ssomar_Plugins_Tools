package org.sptools.ssomar_plugins_tools.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import org.sptools.ssomar_plugins_tools.Main;
import org.sptools.ssomar_plugins_tools.lib.LibClass;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class TextToYamlController implements Initializable {
    LibClass libClass = new LibClass();

    @FXML
    TextArea userInput;

    @FXML
    TextArea outputField;

    @FXML
    public void backToMainPage(ActionEvent event) throws IOException {
        ReusableFunctions.switchMenu(event, getClass(), libClass.mainPage);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // attempt to create a file for read write purposes
        try {
            File jarFile = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            System.out.println("Create Text File at: " + jarFile.getAbsolutePath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
