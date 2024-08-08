package org.example.global_assets;

import javax.swing.*;
import java.awt.*;

public class GlobalFunctions {

    public static JLabel createLabel(String text, float fontSize) {
        JLabel label = new JLabel(text);
        try {
            label.setFont(Font.createFont(Font.TRUETYPE_FONT
                    ,GlobalFunctions.class.getResourceAsStream("/fonts/Inter/Inter-VariableFont_slnt,wght.ttf")).deriveFont(fontSize));

            return label;
        } catch (Exception e) {

        }
        return new JLabel(); // Dummy line
    }

}
