package org.example.panels;

import org.example.global_assets.GlobalFunctions;
import org.example.resource_loader_functions.Resource_Lang;


import javax.swing.*;

public class Option_OtherUtilities extends JPanel  {

    public static JButton button = new JButton();


    public Option_OtherUtilities() {
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder(Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionOtherUtilities_titleBorder"))
        ));

        button.setText(Resource_Lang.langFile.getProperty("MainFrameAttributes_OptionOtherUtilities_labelDescription"));

        this.add(button);
    }
}
