package org.example.resourceLoaderFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Resource_Lang extends Properties{

    public static Properties langFile; // Stores the contents of the config.properties file
    private static String selectedLang;
    public static void run() {
        // For adding more language, refer to this switch case.
        switch (Resource_ConfigPropertiesReader.file.getProperty("language")) {
            case "EN" : selectedLang = "lang_EN.properties";
        }


        try (InputStream input = new FileInputStream("src/main/java/org/example/language/"+selectedLang)) {
            langFile = new Properties();
            // load a properties file
            langFile.load(input);
            // get the property value and print it out
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}