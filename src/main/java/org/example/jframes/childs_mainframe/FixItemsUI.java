package org.example.jframes.childs_mainframe;

import org.example.GlobalFunctions;
import org.example.JFrameObjectHandler;
import org.example.panels.childs_mainframe.FixItemsUI_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FixItemsUI extends JFrame implements ActionListener {
    private ImageIcon programIcon = new ImageIcon("assets/icon.png");
    public static JLabel headerLabel = GlobalFunctions.createLabel(Resource_Lang.langFile.getProperty("FixItemsUI_headerLabel"));
    public static JLabel filePathLabel = GlobalFunctions.createLabel("");
    private JButton backButton = new JButton(Resource_Lang.langFile.getProperty("FixItemsUI_Back"));

    public static FixItemsUI staticObject = new FixItemsUI(); // Used mainly to access nonstatic variables
    public FixItemsUI() {

        this.setSize(1000, 800);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        // CONTENT SECTION =================================================
            headerLabel.setBounds(0, -30, 1000, 100);
            headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            filePathLabel.setBounds(0, 0, 1000, 100);
            filePathLabel.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(headerLabel);
            this.add(filePathLabel);
            this.add(new FixItemsUI_Attributes());
            this.backButton.addActionListener(this);
            this.backButton.setBounds(350, 720, 300, 30);
            this.add(this.backButton);
        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            JFrameObjectHandler.mainObj.changeOpenedJFrame(JFrameObjectHandler.JFRAMES.MAIN_FRAME);
        }
    }

}
