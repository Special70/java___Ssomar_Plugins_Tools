package org.sptools.ssomar_plugins_tools.lib;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ReusableFunctions {

    private static final LibClass libClass = new LibClass();

    /**
     *
     * @param event (the ActionEvent argument from the function)
     * @param classArg (just provide "getClass()" )
     * @param filePath (provide the exact filepath starting from resources folder)
     * @throws IOException
     */
    public static void switchMenu(ActionEvent event,
                                  Class<?> classArg,
                                  String filePath
    ) throws IOException {
        Parent root = FXMLLoader.load(classArg.getResource(filePath));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        applyCSS(scene, classArg, filePath);


        stage.setScene(scene);
        stage.show();
    }

    /**
     * It's a way to properly reapplying the appropriate css file
     */
    private static void applyCSS(Scene scene, Class<?> classArg, String filePath) {
        if (filePath.equals(libClass.mainPage)) scene.getStylesheets().add(classArg.getResource(libClass.mainPageCss).toExternalForm());
        else if (filePath.equals(libClass.configFixerController)) scene.getStylesheets().add(classArg.getResource(libClass.configFixerControllerCss).toExternalForm());


    }
}
