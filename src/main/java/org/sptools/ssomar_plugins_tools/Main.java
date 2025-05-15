package org.sptools.ssomar_plugins_tools;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.sptools.ssomar_plugins_tools.controllers.MainPageController;
import org.sptools.ssomar_plugins_tools.lib.LibClass;
import org.sptools.ssomar_plugins_tools.startup.SettingsStartup;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {
    LibClass libClass = new LibClass();

    @Override
    public void start(Stage stage) throws IOException {
        // execute startup code
        new SettingsStartup();


        // scene
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(libClass.mainPage));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(this.getClass().getResource(libClass.mainPageCss).toExternalForm());

        // controllers
        MainPageController mainPageController = fxmlLoader.getController();
        mainPageController.setStage(stage);

        // stage
        stage.getIcons().add(new Image(getClass().getResourceAsStream(libClass.appIcon)));
        stage.setTitle("Ssomar Plugins Tools");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        /*
        try {
            File jarFile = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            System.out.println("JAR file location: " + jarFile.getAbsolutePath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        */

        launch();
    }
}