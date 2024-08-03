package org.example.jframes.childs_mainframe;

import org.example.back_end_functions.FixItems_Processor;
import org.example.global_assets.ConsoleWindow;
import org.example.global_assets.GlobalFunctions;
import org.example.JFrameObjectHandler;
import org.example.panels.childs_mainframe.FixItemsUI_Attributes;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FixItemsUI extends JFrame implements ActionListener {
    private ImageIcon programIcon = new ImageIcon("assets/icon.png");
    public static JLabel headerLabel = GlobalFunctions.createLabel(Resource_Lang.langFile.getProperty("FixItemsUI_headerLabel"));
    public static JLabel filePathLabel = GlobalFunctions.createLabel("");
    private JButton backButton = new JButton(Resource_Lang.langFile.getProperty("FixItemsUI_Back"));

    /**
     * For assigning names to jbuttons when using actionPerformed
     */
    private enum ActionName {
        BACK_BUTTON,
        START_BUTTON
    }

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
            this.backButton.setActionCommand(ActionName.BACK_BUTTON.name());
            this.backButton.addActionListener(this);
            this.backButton.setBounds(350, 720, 300, 30);
            this.add(this.backButton);

            // ADDING ACTION LISTENER FROM ATTRIBUTE JPANEL CLASS FILE
            FixItemsUI_Attributes.startButton.setActionCommand(ActionName.START_BUTTON.name());
            System.out.println("INVESTIGATE TRIGGER COUNTS HERE");
            if (FixItemsUI_Attributes.startButton.getActionListeners().length < 1) {
                FixItemsUI_Attributes.startButton.addActionListener(this);
            }
        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), ActionName.BACK_BUTTON.name())) {
            JFrameObjectHandler.changeOpenedJFrame(JFrameObjectHandler.JFRAMES.MAIN_FRAME);
        }
        else if (Objects.equals(e.getActionCommand(), ActionName.START_BUTTON.name())) {
            // Initiate Warning Message
            if (JOptionPane.showConfirmDialog(null
                    ,Resource_Lang.langFile.getProperty("FixItemsUI_confirmMsg")
                    ,Resource_Lang.langFile.getProperty("FixItemsUI_confirmTitle")
                    ,JOptionPane.YES_NO_OPTION) > 0) {
                    return;
            }
            // Open the console window
            ConsoleWindow.bootConsole();
            // Creates a new object instance for thread execution
            FixItems_Processor processor = new FixItems_Processor();
            processor.start();

        }
    }

}