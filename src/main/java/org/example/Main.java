package org.example;

import static org.example.JFrameObjectHandler.mainObj;

public class Main {

    public static void main(String[] args) {
        ResourceLoader.run(); // Run resource loader. AKA setting up backend stuff such as settings
        mainObj.swingUtilitiesInvokeLater(); // Load all GUI (Javax Swing) JFrames. AKA starting the actual program
    }

}
