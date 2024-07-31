package org.example.resource_loader_functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Resource_ConfigPropertiesReader {
    public static Properties file; // Stores the contents of the config.properties file
    public static void run() {
        // Loads the .properties file
        try (InputStream input = new FileInputStream("src/main/java/org/example/config.properties")) {
            file = new Properties();
            // load a properties file
            file.load(input);
            // get the property value and print it out
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }





}
