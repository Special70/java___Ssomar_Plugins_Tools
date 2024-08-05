package org.example.resource_loader_functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Resource_ConfigPropertiesReader {
    public static Properties file = new Properties(); // Stores the contents of the config.properties file
    public static void run() {
        // Loads the .properties file
        String resourceName = "config.properties"; // could also be a constant
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            file.load(resourceStream);
        } catch (Exception e) {

        }


    }





}
