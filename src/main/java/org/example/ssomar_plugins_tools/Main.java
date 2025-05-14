package org.example.ssomar_plugins_tools;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.example.ssomar_plugins_tools.class_assets.LibClass;

import java.io.IOException;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LibClass libclass = new LibClass();

        // assets
        Image icon = new Image(libclass.applicationIcon);

        // scenes
        Scene scene = new Scene(root, Color.BLUE); // like a JPanel/<div>

        // stages
        stage.setTitle("Stage Demo");
        stage.getIcons().add(icon);

        stage.setScene(scene);


        Platform.runLater(stage::centerOnScreen);
        stage.show();
    }
}