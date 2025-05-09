package org.example.jframes;

import li.flor.nativejfilechooser.NativeJFileChooser;
import org.example.System_JFrameObjectHandler;
import org.example.jframes.childs_mainframe.FixItemsUI;
import org.example.jframes.childs_mainframe.OtherOptionsUI;
import org.example.panels.MainFrame_Attributes;
import org.example.panels.Option_FixItems;
import org.example.panels.Option_OtherUtilities;
import org.example.resource_loader_functions.Resource_GlobalVariables;
import org.example.resource_loader_functions.Resource_Images;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends JFrame implements ActionListener {
    private final ImageIcon programIcon = Resource_Images.getImage("/images/icon.png");
    private final JFileChooser folderChooser = new NativeJFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    private final JFileChooser fileChooser = new NativeJFileChooser(FileSystemView.getFileSystemView());


    public MainFrame() {
        this.setSize(1000, 800);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        folderChooser.setCurrentDirectory(new File("."));
        folderChooser.setDialogTitle("Select Folder");
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setAcceptAllFileFilterUsed(false);

        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setDialogTitle("Select a random YML file");
        fileChooser.setAcceptAllFileFilterUsed(false);

        // CONTENT SECTION =================================================
            this.add(new MainFrame_Attributes());

            // ADDING ACTION LISTENER FROM ATTRIBUTE JPANEL CLASS FILE
            Option_FixItems.button.addActionListener(this);
            Option_OtherUtilities.button.addActionListener(this);
        // CONTENT SECTION =================================================

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Option_FixItems.button) {
            // Uses JFileChooser to select folders instead of files

            if (folderChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                Resource_GlobalVariables.selectedFilePath = folderChooser.getSelectedFile().toString();
                FixItemsUI.filePathLabel.setText("Selected Path: " + Resource_GlobalVariables.selectedFilePath); // Sets the jlabel value to show the selected file path
                System_JFrameObjectHandler.changeOpenedJFrame(System_JFrameObjectHandler.JFRAMES.FIX_ITEMS_UI);
            }
        } else if (e.getSource() == Option_OtherUtilities.button) {
            // Opens a new window
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                Resource_GlobalVariables.selectedFilePath = fileChooser.getSelectedFile().toString();
                OtherOptionsUI.filePathLabel.setText("Selected Path: " + Resource_GlobalVariables.selectedFilePath); // Sets the jlabel value to show the selected file path
                System_JFrameObjectHandler.changeOpenedJFrame(System_JFrameObjectHandler.JFRAMES.OTHER_OPTIONS_UI);
            }
        }
    }

}
