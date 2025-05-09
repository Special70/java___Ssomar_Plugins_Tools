package org.example.jframes.childs_mainframe;

import org.example.System_JFrameObjectHandler;
import org.example.back_end_functions.FixItems_Processor;
import org.example.global_assets.ConsoleWindow;
import org.example.global_assets.GlobalFunctions;
import org.example.panels.childs_mainframe_fixitems.OtherOptionsUI_Attributes;
import org.example.panels.childs_mainframe_fixitems.Selection_Functions;
import org.example.resource_loader_functions.Resource_Images;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class OtherOptionsUI extends JFrame implements ActionListener {
    private ImageIcon programIcon = Resource_Images.getImage("/images/icon.png");
    public static JLabel headerLabel = GlobalFunctions.createLabel("Other Options", 20);
    public static JLabel filePathLabel = GlobalFunctions.createLabel("", 20);
    private JButton backButton = new JButton("Click here to go back");

    private enum ActionName {
        BACK_BUTTON,
        START_BUTTON
    }

    public OtherOptionsUI() {

        this.setSize(1000, 800);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        // CONTENT SECTION =================================================
        headerLabel.setBounds(0, -30, 1000, 100);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(headerLabel);
        this.add(new OtherOptionsUI_Attributes());
        this.backButton.setActionCommand(OtherOptionsUI.ActionName.BACK_BUTTON.name());
        this.backButton.addActionListener(this);
        this.backButton.setBounds(350, 720, 300, 30);
        this.add(this.backButton);
        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), OtherOptionsUI.ActionName.BACK_BUTTON.name())) {
            System_JFrameObjectHandler.changeOpenedJFrame(System_JFrameObjectHandler.JFRAMES.MAIN_FRAME);
        }
    }
}
