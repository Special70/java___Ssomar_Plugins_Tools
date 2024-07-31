package org.example.resource_loader_functions;

import org.example.JFrameObjectHandler;

public class Resource_GlobalVariables {
    public static String selectedFilePath = "None Selected";
    public static JFrameObjectHandler.JFRAMES currentlyOpenedJFrame = JFrameObjectHandler.JFRAMES.MAIN_FRAME; // Stores what UI is opened so the rest of the program knows which UI is opened at the moment
}
