package org.example.jframes.childs_mainframe.childs_fixitemsui;

import org.example.GlobalFunctions;
import org.example.JFrameObjectHandler;
import org.example.JFrameObjectHandler.JFRAMES;
import org.example.panels.childs_mainframe.childs_fixitemsui.FixItemsUI_ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FixItemsUI_ConsoleWindow extends JFrame implements ActionListener {
    private ImageIcon programIcon = new ImageIcon("assets/icon.png");
    private JLabel headerLabel = GlobalFunctions.createLabel(Resource_Lang.langFile.getProperty("FixItemsUI_ConsoleWindow_headerLabel"));
    private JButton backButton = new JButton(Resource_Lang.langFile.getProperty("FixItemsUI_ConsoleWindow_backButton"));

    public FixItemsUI_ConsoleWindow() {
        this.setSize(1500, 1000);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        // CONTENT SECTION =================================================
        this.add(new FixItemsUI_ConsoleWindow_Attributes());
        this.backButton.addActionListener(this);
        this.backButton.setBounds(500, 900, 500, 30);
        this.add(this.backButton);

        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setLocationRelativeTo(null);

        this.headerLabel.setBounds(500, 0, 500, 50);
        this.headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.headerLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            JFrameObjectHandler.changeOpenedJFrame(JFRAMES.MAIN_FRAME);
        }
    }
}
