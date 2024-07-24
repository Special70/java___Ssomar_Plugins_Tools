package org.example;

import org.example.resourceLoaderFunctions.Resource_Fonts;

import javax.swing.*;

public class ResourceLoader {
    public static void run() {
        // Adjust UI Looks
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Resource_Fonts.run(); // Load Fonts
    }
}
