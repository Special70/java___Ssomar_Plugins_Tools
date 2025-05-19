package org.sptools.ssomar_plugins_tools.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.sptools.ssomar_plugins_tools.lib.LibClass;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TextToYamlController implements Initializable {
    LibClass libClass = new LibClass();

    Stage stage;

    @FXML
    public TextArea userInput;
    @FXML
    public TextArea outputField;
    @FXML
    public AnchorPane rootPane;

    /**
     * Returns the user back ot the main page
     */
    @FXML
    public void backToMainPage(ActionEvent event) throws IOException {
        ReusableFunctions.switchMenu(event, getClass(), libClass.mainPage);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Platform.runLater(() -> {
            this.stage = ReusableFunctions.getStage(userInput);
        });
        userInput.textProperty().addListener((obs, oldText, newText) -> {
            String[] lines = newText.split("\\R"); // splits on any line break
            StringBuilder yamlBuilder = new StringBuilder();
            yamlBuilder.append("    commands:\n");
            for (String line : lines) {
                if (!line.isBlank()) {
                    yamlBuilder.append("    - ").append(quoteIfNeeded(line)).append("\n");
                }
            }
            outputField.setText(yamlBuilder.toString());
        });


    }

    /**
     * Checks if the input requires to be surrounded in quotes or not.
     * YAML has issues with specific characters, and we can't expect everyone
     * to know where to put the quote symbols exactly.
     */
    private String quoteIfNeeded(String value) {
        // YAML quoting is needed if:
        // - the string contains special characters
        // - starts with `@`, `&`, `*`, `!`, `?`, `-`, etc.
        // - contains `:`, `#`, `{`, `}`, `[`, `]`, `,`, `|`, `>`, etc.
        // - contains whitespace or line breaks
        // - or matches boolean/null/numeric keywords like true, false, null, 123

        boolean needsQuoting = value.matches(".*[\\s:#\\[\\]\\{\\},&*!|>'\"%@`].*")
                || value.equalsIgnoreCase("null")
                || value.equalsIgnoreCase("true")
                || value.equalsIgnoreCase("false")
                || value.matches("^[0-9]+$");

        if (needsQuoting) {
            // Escape any single quotes by doubling them (YAML rule)
            String escaped = value.replace("'", "''");
            return "'" + escaped + "'";
        }

        return value;
    }


}
