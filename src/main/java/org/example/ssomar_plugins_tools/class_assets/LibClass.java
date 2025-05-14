package org.example.ssomar_plugins_tools.class_assets;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The idea for this class is to centralize asset usage to consider
 * the possibility of code expansion
 */
public class LibClass {
    public final String applicationIcon;
    public final Parent firstScene;
    // fxml

    public LibClass() throws IOException {
        applicationIcon = getClass().getResource("/assets/images/icon.png").toExternalForm();
        firstScene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
    }
}
