package org.sptools.ssomar_plugins_tools.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.sptools.ssomar_plugins_tools.lib.LibClass;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;
import org.sptools.ssomar_plugins_tools.system.SystemVariables;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    LibClass libClass = new LibClass();

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Button configFixerButton;
    public Button textToYamlButton;


    /**
     * Opens the folder for the user to select which folder contains the items
     * the user wishes to fix
     */
    @FXML
    public void openFolderPrompt(ActionEvent event) throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Folder");
        File selectedDirectory = directoryChooser.showDialog(stage);

        if (selectedDirectory != null) {
            SystemVariables.selectedDirectory = selectedDirectory.getAbsolutePath();

            System.out.println("Selected folder: " + selectedDirectory.getAbsolutePath());
            FXMLLoader loader = new FXMLLoader(getClass().getResource(libClass.configFixerController));
            root = loader.load();


            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource(libClass.configFixerControllerCss).toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Opens the menu that converts provided text to yaml format.
     * Why does this option exist? Sometimes people paste things from MCStacker
     * and when they reload the plugin, the .yml file breaks due to syntax error.
     */
    @FXML
    public void openTextToYamlConverter(ActionEvent event) throws IOException {
        ReusableFunctions.switchMenu(event, getClass(), libClass.textToYaml);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            this.stage = ReusableFunctions.getStage(configFixerButton);
        });
    }
}