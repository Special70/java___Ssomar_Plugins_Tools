package org.sptools.ssomar_plugins_tools.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.sptools.ssomar_plugins_tools.lib.LibClass;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigFixerController implements Initializable {
    LibClass libClass = new LibClass();

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private CheckBox choice1;

    @FXML
    private CheckBox choice2;

    @FXML
    private Label directoryLabel;

    @FXML
    private ChoiceBox<String> particleCmdConversion;

    public void setDirectoryLabel(String path) {
        directoryLabel.setText(path);
    }

    private String[] particleCmdConversionChoices = new String[]{
            "Upgrade all particle commands to 1.13+",
            "Downgrade all 1.13+ particle commands"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        particleCmdConversion.getItems().addAll(particleCmdConversionChoices);
    }

    @FXML
    public void backToMainPage(ActionEvent event) throws IOException {
        ReusableFunctions.switchMenu(event, getClass(), libClass.mainPage);
    }
}
