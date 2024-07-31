package org.example.resource_loader_functions;

import java.awt.*;
import java.io.File;

public class Resource_Fonts {
    public static Font interVariable;

    public static void run() {

        // interVariable
        try {
            File fontFile = new File("assets/fonts/Inter/Inter-VariableFont_slnt,wght.ttf");
            interVariable = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(20f);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
