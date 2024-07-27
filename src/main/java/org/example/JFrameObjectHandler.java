package org.example;

import org.example.jframes.MainFrame;
import org.example.jframes.childs_mainFrame.FixItemsUI;

import javax.swing.*;

public class JFrameObjectHandler {
    // Stores all JFrame objects here so it can be easily controlled.
    // The main purpose of this class file is to be able to make class files across the program
    // to be capable of enabling/disabling visibility of jframes by access
    public MainFrame mainFrameObj; // Holds the heart of the program. If this object dies somehow, most of the program will
    public FixItemsUI fixItemsUIObj;




    public static JFrameObjectHandler mainObj = new JFrameObjectHandler(); // Mainly used to be able to create a non-static MainFrame object using SwingUtilities.invokeLater();

    public void swingUtilitiesInvokeLater() {
        SwingUtilities.invokeLater(() -> {
            this.mainFrameObj = new MainFrame();
                this.fixItemsUIObj = new FixItemsUI();
        }
        );
    }
    // For running the main gui JFrame in an invokeLater method


}