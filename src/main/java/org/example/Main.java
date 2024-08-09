package org.example;

import static org.example.System_JFrameObjectHandler.mainObj;

public class Main {

    /**
     * For action trigger methods, go to {@link org.example.jframes} and its contents
     */
    public static void main(String[] args) {
        ResourceLoader resourceLoader = new ResourceLoader(); // Run resource loader. AKA setting up backend stuff such as settings
        try {
            resourceLoader.start();
            resourceLoader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainObj.swingUtilitiesInvokeLater(); // Load all GUI (Javax Swing) JFrames. AKA starting the actual program
    }

}
