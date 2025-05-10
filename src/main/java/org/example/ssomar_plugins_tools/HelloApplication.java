package org.example.ssomar_plugins_tools;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, Color.BLUE); // like a JPanel/<div>

        stage.setTitle("Stage Demo");
        Image icon = new Image(getClass().getResource("/assets/images/icon.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setWidth(1280);
        stage.setHeight(960);
        stage.setResizable(false);




        stage.setScene(scene);
        // put this at the end of the code
        stage.show();
    }
}