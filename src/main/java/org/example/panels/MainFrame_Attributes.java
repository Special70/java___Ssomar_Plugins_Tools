package org.example.panels;

import org.example.global_assets.GlobalFunctions;

import javax.swing.*;
import java.awt.*;

public class MainFrame_Attributes extends JPanel {
    private JLabel topLabel;
    private JPanel contentPanel;


    public MainFrame_Attributes() {

        // Indentions will indicate parent level

        // ===================================================================
        this.setLayout(new BorderLayout(2, 2));
        this.topLabel = GlobalFunctions.createLabel("Ssomar Plugins Utility Program", 20);
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

