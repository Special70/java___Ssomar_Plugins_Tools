package org.example;

import org.example.panels.MainFrameAttributes;

import javax.swing.*;

public class MainFrame extends JFrame {
    ImageIcon programIcon = new ImageIcon("assets/icon.png");
    MainFrame() {
        this.setSize(1000, 800);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        // CONTENT SECTION =================================================
        this.add(new MainFrameAttributes());

        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
