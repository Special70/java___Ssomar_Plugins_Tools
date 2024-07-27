package org.example.panels;

import org.example.GlobalFunctions;
import org.example.JFrameObjectHandler;
import org.example.resourceLoaderFunctions.Resource_Lang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrameAttributes extends JPanel {
    private JLabel topLabel;
    private JPanel contentPanel;


    public MainFrameAttributes() {

        // Indentions will indicate parent level

        // ===================================================================
        this.setLayout(new BorderLayout(2, 2));
        this.topLabel = GlobalFunctions.createLabel("Ssomar Plugins Utility Program");
        this.topLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(this.topLabel, BorderLayout.NORTH);

        contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createDashedBorder(null)
        ));
        contentPanel.setLayout(new GridLayout(3, 1, 40, 40));
            // ===================================================================
            contentPanel.add(new Option_FixItems());
            // ===================================================================
        this.add(contentPanel, BorderLayout.CENTER);


        // ===================================================================
        this.setBounds(200, 50, 600, 600);
        this.setBorder(BorderFactory.createDashedBorder(null));

    }
}

// JPanel that holds the button that allows users to select a folder to
// open another GUI that allows the users to select what issues they want to fix

class Option_FixItems extends JPanel implements ActionListener {
    public String selectedFolderPath;
    private void setSelectedFolderPath(String path) {selectedFolderPath = path;}
    private JButton button = new JButton();
    private JLabel labelDescription = GlobalFunctions.createLabel(Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionFixItems_labelDescription"));

    Option_FixItems() {
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder( Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionFixItems_titleBorder"))
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
            this.setSelectedFolderPath(chooser.getSelectedFile().toString());
            JFrameObjectHandler.mainObj.mainFrameObj.setVisible(false);
            JFrameObjectHandler.mainObj.fixItemsUIObj.setVisible(true);
        }
    }
}