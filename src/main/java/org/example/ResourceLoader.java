package org.example;

import org.example.resource_loader_functions.Resource_ConfigPropertiesReader;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;

public class ResourceLoader extends Thread {
    @Override
    public void run() {
        // Adjust UI Looks
        try {
            // Changes the default setLookAndFeel of javax swing stuff
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // Makes tooltips show up instantly when there's one
            ToolTipManager.sharedInstance().setInitialDelay(0);
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
