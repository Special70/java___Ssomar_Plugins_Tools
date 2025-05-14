package org.sptools;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello world!");
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        LibClass libClass = new LibClass();

        // nodes
        Parent root = FXMLLoader.load(getClass().getResource(libClass.mainPagePath));

        // scene
        Scene scene = new Scene(root);

        // stage
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(libClass.appIconPath)));
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();



    }
}