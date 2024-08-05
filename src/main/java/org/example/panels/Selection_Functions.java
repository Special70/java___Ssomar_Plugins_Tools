package org.example.panels;

import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.*;

public class Selection_Functions extends JPanel {
    public static JCheckBox button_specifyVanillaCommands = new JCheckBox(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_button-fixTPCommand"));
    public static JCheckBox button_convertDustCommandsTo_1_20_5 = new JCheckBox(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_button-convertDustCommandToPre-1-20-5"));

    public Selection_Functions() {
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20),
                BorderFactory.createTitledBorder(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_border"))
        ));
        this.setLayout(new FlowLayout());
        this.add(button_specifyVanillaCommands);
        this.add(button_convertDustCommandsTo_1_20_5);

    }
}