package org.example.jframes.childs_mainframe.childs_fixitemsui;

import org.example.GlobalFunctions;
import org.example.panels.childs_mainframe.childs_fixitemsui.FixItemsUI_ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;

public class FixItemsUI_ConsoleWindow extends JFrame {
    private ImageIcon programIcon = new ImageIcon("assets/icon.png");
    private JLabel headerLabel = GlobalFunctions.createLabel(Resource_Lang.langFile.getProperty("FixItemsUI_ConsoleWindow_headerLabel"));

    public FixItemsUI_ConsoleWindow() {
        this.setSize(1000, 800);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        // CONTENT SECTION =================================================
        this.add(new FixItemsUI_ConsoleWindow_Attributes());

        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setLocationRelativeTo(null);

        this.headerLabel.setBounds(250, 0, 500, 50);
        this.headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.headerLabel);
    }
}
