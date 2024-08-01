package org.example;

import org.example.resource_loader_functions.Resource_Fonts;

import javax.swing.*;
import java.util.regex.Pattern;

public class GlobalFunctions {

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Resource_Fonts.interVariable);
        return label;
    }

}
