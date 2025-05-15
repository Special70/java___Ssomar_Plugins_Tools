package org.sptools.ssomar_plugins_tools.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import org.sptools.ssomar_plugins_tools.lib.LibClass;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MainPageController {
    LibClass libClass = new LibClass();

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Button configFixerButton;
    public Button cmdConverterFixerButton;
    public Button textToYamlButton;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void openFolderPrompt(ActionEvent event) throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Folder");
        File selectedDirectory = directoryChooser.showDialog(stage);

        if (selectedDirectory != null) {
            System.out.println("Selected folder: " + selectedDirectory.getAbsolutePath());
            FXMLLoader loader = new FXMLLoader(getClass().getResource(libClass.configFixerController));
            root = loader.load();

            ConfigFixerController controller = loader.getController();
            controller.setDirectoryLabel(selectedDirectory.getAbsolutePath());

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource(libClass.configFixerControllerCss).toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void openTextToYamlConverter(ActionEvent event) throws IOException {
        ReusableFunctions.switchMenu(event, getClass(), libClass.textToYaml);
    }




}