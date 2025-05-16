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
import org.sptools.ssomar_plugins_tools.jobs.JobHandler;
import org.sptools.ssomar_plugins_tools.lib.LibClass;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;
import org.sptools.ssomar_plugins_tools.system.SystemVariables;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConfigFixerController implements Initializable {
    LibClass libClass = new LibClass();

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public CheckBox choice1;

    @FXML
    public CheckBox choice2;

    @FXML
    public ChoiceBox<String> choice2_1;

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

    @FXML
    public void startJob(ActionEvent event) throws IOException {
        SystemVariables.previousMenuPath = libClass.configFixerController;

        // start building the info to pass to JobHandler.start()
        // so it knows what jobs to perform
        ArrayList<String> paramBuilder = new ArrayList<>();

        if (choice1.isSelected()) paramBuilder.add("job-1.0");
        if (choice2.isSelected() && particleCmdConversion.getValue().equals("Upgrade all particle commands to 1.13+")) paramBuilder.add("job-2.0");
        if (choice2.isSelected() && particleCmdConversion.getValue().equals("Downgrade all 1.13+ particle commands")) paramBuilder.add("job-2.1");

        ReusableFunctions.switchMenu(event, getClass(), libClass.consoleWindow);
        JobHandler.start(paramBuilder.toArray(new String[paramBuilder.size()]));

    }
}
