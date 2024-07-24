package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ResourceLoader.run(); // Run resource loader
        SwingUtilities.invokeLater(runMainFrame);
    }
    // For running the main gui JFrame in an invokeLater method
    private static Runnable runMainFrame = new Runnable() {
        @Override
        public void run() {
            new MainFrame();
        }
    };

}