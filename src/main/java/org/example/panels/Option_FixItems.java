package org.example.panels;

import org.example.GlobalFunctions;
import org.example.JFrameObjectHandler;
import org.example.jframes.childs_mainframe.FixItemsUI;
import org.example.resource_loader_functions.Resource_GlobalVariables;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class Option_FixItems extends JPanel implements ActionListener {
    private JButton button = new JButton();
    private JLabel labelDescription = GlobalFunctions.createLabel(Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionFixItems_labelDescription"));

    Option_FixItems() {
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder(Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionFixItems_titleBorder"))
        ));

        this.button.setText(Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionFixItems_button"));
        this.button.addActionListener(this);

        this.add(button);
        this.add(labelDescription);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Uses JFileChooser to select folders instead of files
        JFileChooser chooser = new JFileChooser();
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
