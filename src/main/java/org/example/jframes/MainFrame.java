package org.example.jframes;

import org.example.panels.MainFrame_Attributes;

import javax.swing.*;

public class MainFrame extends JFrame {
    private ImageIcon programIcon = new ImageIcon("assets/icon.png");

    public MainFrame() {
        this.setSize(1000, 800);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        // CONTENT SECTION =================================================
            this.add(new MainFrame_Attributes());

        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void toggleVisibility() {
        this.setVisible(!this.isVisible());
    }
}
