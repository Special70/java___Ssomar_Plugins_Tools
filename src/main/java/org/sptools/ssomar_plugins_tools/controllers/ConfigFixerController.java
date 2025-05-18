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

/**
 * This controller deals with the fxml file ({@link LibClass#appIcon}) to perform operations.
 */
public class ConfigFixerController implements Initializable {
    LibClass libClass = new LibClass();

    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Checkbox to the first option in the ConfigFixer UI. If enabled, it will perform
     * the tasks written at {@link org.sptools.ssomar_plugins_tools.jobs.Job_ApplyMinecraftToCommands}
     */
    @FXML
    public CheckBox choice1;

    /**
     * Checkbox to the first option in the ConfigFixer UI. If enabled, it will perform
     * the tasks written at {@link org.sptools.ssomar_plugins_tools.jobs.Job_ApplyMinecraftToCommands}.
     * (The user still needs to specify between the two choices written at {@link ConfigFixerController#choice2_1})
     */
    @FXML
    public CheckBox choice2;

    /**
     * Contains the choices the user can select for {@link ConfigFixerController#choice2}.
     * The context for this choice is that the user can select either to upgrade or downgrade
     * particle commands. There can only be one of the two.
     */
    @FXML
    public ChoiceBox<String> choice2_1;
    @FXML
    private String[] particleCmdConversionChoices = new String[]{
            "Upgrade all particle commands to 1.13+",
            "Downgrade all 1.13+ particle commands"};

    /**
     * Once a folder is selected during the MainPage, it will be displayed here.<br/>
     * Edited by {@link ConfigFixerController#setDirectoryLabel(String)}
     */
    @FXML
    private Label directoryLabel;

    /**
     * Modifies the Control label so the user would know what folder
     * got selected.
     */
    public void setDirectoryLabel(String path) {
        directoryLabel.setText(path);
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choice2_1.getItems().addAll(particleCmdConversionChoices);
    }

    /**
     * Returns the user back to the main page
     */
    @FXML
    public void backToMainPage(ActionEvent event) throws IOException {
        ReusableFunctions.switchMenu(event, getClass(), libClass.mainPage);
    }

    /**
     * Starts executing selected jobs by the user
     */
    @FXML
    public void startJob(ActionEvent event) throws IOException {
        SystemVariables.previousMenuPath = libClass.configFixerController;

        // start building the info to pass to JobHandler.start()
        // so it knows what jobs to perform
        ArrayList<String> paramBuilder = new ArrayList<>();

        if (choice1.isSelected()) paramBuilder.add("job-1.0");
        if (choice2.isSelected() && choice2_1.getValue().equals("Upgrade all particle commands to 1.13+")) paramBuilder.add("job-2.0");
        if (choice2.isSelected() && choice2_1.getValue().equals("Downgrade all 1.13+ particle commands")) paramBuilder.add("job-2.1");

        ReusableFunctions.switchMenu(event, getClass(), libClass.consoleWindow);
        JobHandler.start(paramBuilder.toArray(new String[paramBuilder.size()]));

    }
}
