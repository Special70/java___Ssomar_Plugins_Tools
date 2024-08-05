package org.example.resource_loader_functions;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Resource_Lang extends Properties{

    public static Properties langFile = new Properties(); // Stores the contents of the config.properties file
    private static String selectedLang;
    public static void run() {
        // For adding more language, refer to this switch case.
        switch (Resource_ConfigPropertiesReader.file.getProperty("language")) {
            case "EN" : selectedLang = "lang_EN.properties"; break;
            default: selectedLang = "lang_EN.properties"; break;
        }

        /*
        try (InputStream input = new FileInputStream("src/main/java/org/example/language/"+selectedLang)) {
            langFile = new Properties();
            // load a properties file
            langFile.load(input);
            // get the property value and print it out
        } catch (IOException ex) {
            ex.printStackTrace();
        }

         */
        try (InputStream resourceStream = Resource_Lang.class.getResourceAsStream("/language/"+selectedLang)) {
            langFile.load(resourceStream);
            System.out.println(langFile.getProperty("MainFrameAttributes_OptionFixItems_button"));
        } catch (Exception e) {

        }


    }
}
