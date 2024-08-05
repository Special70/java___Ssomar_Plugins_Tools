package org.example.jframes;

import li.flor.nativejfilechooser.NativeJFileChooser;
import org.example.JFrameObjectHandler;
import org.example.jframes.childs_mainframe.FixItemsUI;
import org.example.panels.MainFrame_Attributes;
import org.example.panels.Option_FixItems;
import org.example.resource_loader_functions.Resource_GlobalVariables;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends JFrame implements ActionListener {
    private ImageIcon programIcon = new ImageIcon("assets/icon.png");

    public MainFrame() {
        this.setSize(1000, 800);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        // CONTENT SECTION =================================================
            this.add(new MainFrame_Attributes());

            // ADDING ACTION LISTENER FROM ATTRIBUTE JPANEL CLASS FILE
            Option_FixItems.button.addActionListener(this);
        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Option_FixItems.button) {
            // Uses JFileChooser to select folders instead of files
            JFileChooser chooser = new NativeJFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            chooser.setCurrentDirectory(new File("."));
            chooser.setDialogTitle("Select Folder");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                Resource_GlobalVariables.selectedFilePath = chooser.getSelectedFile().toString();
                FixItemsUI.filePathLabel.setText("Selected Path: " + Resource_GlobalVariables.selectedFilePath); // Sets the jlabel value to show the selected file path
                JFrameObjectHandler.changeOpenedJFrame(JFrameObjectHandler.JFRAMES.FIX_ITEMS_UI);
            }
        }
    }

}
