package org.example;

import org.example.resourceLoaderFunctions.Resource_Fonts;

import javax.swing.*;

public class GlobalFunctions {

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Resource_Fonts.interVariable);
        return label;
    }
}