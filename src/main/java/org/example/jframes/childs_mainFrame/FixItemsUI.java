package org.example.jframes.childs_mainFrame;

import org.example.panels.childs_mainFrame.FixItemsUIAttributes;

import javax.swing.*;

public class FixItemsUI extends JFrame {
    ImageIcon programIcon = new ImageIcon("assets/icon.png");
    public FixItemsUI() {

        this.setSize(1000, 800);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        // CONTENT SECTION =================================================
            this.add(new FixItemsUIAttributes());
        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

}
