package org.example.resource_loader_functions;

import java.awt.*;

/**
 * This class is responsible for storing static Font variables.<br>
 * Frequently used by:
 * - {@link org.example.global_assets.GlobalFunctions#createLabel(String)}
 *
 */
public class Resource_Fonts {

    public static Font interVariable;


    public static void run() {

        try {
            interVariable = Font.createFont(Font.TRUETYPE_FONT
                    , Resource_Fonts.class.getResourceAsStream("/fonts/Inter/Inter-VariableFont_slnt,wght.ttf"
                    )).deriveFont(20f);
        } catch (Exception e) {

        }

    }
}
