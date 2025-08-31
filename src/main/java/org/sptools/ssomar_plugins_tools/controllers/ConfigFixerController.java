package org.sptools.ssomar_plugins_tools.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.sptools.ssomar_plugins_tools.jobs.JobHandler;
import org.sptools.ssomar_plugins_tools.jobs.operations.Job_ApplyMinecraftToCommands;
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


    /**
     * Checkbox to the first option in the ConfigFixer UI. If enabled, it will perform
     * the tasks written at {@link Job_ApplyMinecraftToCommands}
     */
    @FXML
    public CheckBox choice1;

    /**
     * Checkbox to the first option in the ConfigFixer UI. If enabled, it will perform
     * the tasks written at {@link Job_ApplyMinecraftToCommands}.
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
            "Upgrade all particle commands to 1.20.5+",
            "Downgrade all 1.20.5+ particle commands to 1.13-1.20.4"};

    /**
     * Once a folder is selected during the MainPage, it will be displayed here.<br/>
     * Reference: {@link SystemVariables#selectedDirectory}
     */
    @FXML
    private Label directoryLabel;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.directoryLabel.setText(SystemVariables.selectedDirectory);
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


        // start building the info to pass to JobHandler.start()
        // so it knows what jobs to perform
        ArrayList<String> paramBuilder = new ArrayList<>();

        if (choice1.isSelected()) paramBuilder.add("job-1.0");
        if (choice2.isSelected() && choice2_1.getValue().equals(particleCmdConversionChoices[0])) paramBuilder.add("job-2.0");
        if (choice2.isSelected() && choice2_1.getValue().equals(particleCmdConversionChoices[1])) paramBuilder.add("job-2.1");

        if (paramBuilder.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cannot start jobs.");
            alert.setHeaderText("You have yet to select even at least one job option.");
            alert.showAndWait();
        } else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Do you want to start?");
            alert.setHeaderText("The software is about to modify the .yml item configs in the target folder.");
            alert.setContentText("Please make a backup of the item configs if needed.");

            if (alert.showAndWait().get() == ButtonType.OK) {

                SystemVariables.previousMenuPath = libClass.configFixerController;

                ReusableFunctions.switchMenu(event, getClass(), libClass.consoleWindow);
                JobHandler.start(paramBuilder);
            }
        }



    }
}
