package org.example.global_assets;

import org.example.resource_loader_functions.Resource_Fonts;

import javax.swing.*;

public class GlobalFunctions {

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Resource_Fonts.interVariable);
        return label;
    }

}
