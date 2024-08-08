package org.example;

import org.example.resource_loader_functions.Resource_ConfigPropertiesReader;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;

public class ResourceLoader extends Thread {
    @Override
    public void run() {
        // Adjust UI Looks
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Resource_ConfigPropertiesReader.run(); // Reads config.properties
        Resource_Lang.run(); // Load the correct language properties file

        synchronized (this) {
            notify();
        }
    }
}
