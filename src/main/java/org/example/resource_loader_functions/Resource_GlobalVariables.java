package org.example.resource_loader_functions;

import org.example.JFrameObjectHandler;

public class Resource_GlobalVariables {
    /**
     * This is where the target folder path is stored when selecting the "fix items" option
     */
    public static String selectedFilePath = "None Selected";
    /**
     * This is where the information about what UI is opened at the moment is stored at.
     * No. This does not actively track which JFrame is visible. External code is responsible
     * for rewriting the value that's stored in this variable.
     */
    public static JFrameObjectHandler.JFRAMES currentlyOpenedJFrame = JFrameObjectHandler.JFRAMES.MAIN_FRAME; // Stores what UI is opened so the rest of the program knows which UI is opened at the moment
}
