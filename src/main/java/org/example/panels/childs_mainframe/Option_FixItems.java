package org.example.panels.childs_mainframe;

import org.example.global_assets.GlobalFunctions;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;

public class Option_FixItems extends JPanel {
    public static JButton button = new JButton();
    private JLabel labelDescription = GlobalFunctions.createLabel(Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionFixItems_labelDescription"));

    public Option_FixItems() {
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder(Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionFixItems_titleBorder"))
        ));

        button.setText(Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionFixItems_button"));

        this.add(button);
        this.add(labelDescription);
    }

}
