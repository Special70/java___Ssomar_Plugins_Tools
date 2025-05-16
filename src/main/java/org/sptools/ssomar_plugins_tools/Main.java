package org.sptools.ssomar_plugins_tools;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.sptools.ssomar_plugins_tools.controllers.MainPageController;
import org.sptools.ssomar_plugins_tools.controllers.TextToYamlController;
import org.sptools.ssomar_plugins_tools.lib.LibClass;
import org.sptools.ssomar_plugins_tools.startup.SettingsStartup;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {
    LibClass libClass = new LibClass();

    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        // execute startup code
        new SettingsStartup();

        primaryStage = stage;

        // scene
        FXMLLoader mainPageLoader = new FXMLLoader(getClass().getResource(libClass.mainPage));
        Scene scene = new Scene(mainPageLoader.load());
        scene.getStylesheets().add(this.getClass().getResource(libClass.mainPageCss).toExternalForm());

        // stage
        stage.getIcons().add(new Image(getClass().getResourceAsStream(libClass.appIcon)));
        stage.setTitle("Ssomar Plugins Tools");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}