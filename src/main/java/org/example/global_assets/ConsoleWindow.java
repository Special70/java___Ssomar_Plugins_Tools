package org.example.global_assets;

import org.example.System_JFrameObjectHandler;
import org.example.System_JFrameObjectHandler.JFRAMES;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsoleWindow extends JFrame implements ActionListener {
    private ImageIcon programIcon = new ImageIcon("assets/icon.png");
    private JLabel headerLabel = GlobalFunctions.createLabel(Resource_Lang.langFile.getProperty("FixItemsUI_ConsoleWindow_headerLabel"), 20);
    private JButton backButton = new JButton(Resource_Lang.langFile.getProperty("FixItemsUI_ConsoleWindow_backButton"));

    public static void bootConsole() {
        ConsoleWindow_Attributes.consoleWindowOutput.setText(""); // Wipe console
        System_JFrameObjectHandler.changeOpenedJFrame(JFRAMES.CONSOLE_WINDOW);
    }

    public ConsoleWindow() {
        this.setSize(1500, 1000);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        // CONTENT SECTION =================================================
        this.add(new ConsoleWindow_Attributes());
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
            System_JFrameObjectHandler.changeOpenedJFrame(JFRAMES.MAIN_FRAME);
        }
    }
}
