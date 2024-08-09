package org.example.jframes;

import li.flor.nativejfilechooser.NativeJFileChooser;
import org.example.System_JFrameObjectHandler;
import org.example.jframes.childs_mainframe.FixItemsUI;
import org.example.panels.MainFrame_Attributes;
import org.example.panels.Option_FixItems;
import org.example.resource_loader_functions.Resource_GlobalVariables;
import org.example.resource_loader_functions.Resource_Images;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends JFrame implements ActionListener {
    private final ImageIcon programIcon = Resource_Images.getImage("/images/icon.png");
    private final JFileChooser chooser = new NativeJFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


    public MainFrame() {
        this.setSize(1000, 800);
        this.setTitle("Ssomar Plugins Tools");
        this.setIconImage(programIcon.getImage());
        this.setLayout(null);

        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

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

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                Resource_GlobalVariables.selectedFilePath = chooser.getSelectedFile().toString();
                FixItemsUI.filePathLabel.setText("Selected Path: " + Resource_GlobalVariables.selectedFilePath); // Sets the jlabel value to show the selected file path
                System_JFrameObjectHandler.changeOpenedJFrame(System_JFrameObjectHandler.JFRAMES.FIX_ITEMS_UI);
            }
        }
    }

}
