package org.example;

import org.example.resourceLoaderFunctions.Resource_Fonts;
import org.example.resourceLoaderFunctions.Resource_ConfigPropertiesReader;
import org.example.resourceLoaderFunctions.Resource_Lang;

import javax.swing.*;

public class ResourceLoader {
    public static void run() {
        // Adjust UI Looks
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Resource_ConfigPropertiesReader.run(); // Reads config.properties
        Resource_Fonts.run(); // Load Fonts
        Resource_Lang.run(); // Load the correct language properties file
    }
}
