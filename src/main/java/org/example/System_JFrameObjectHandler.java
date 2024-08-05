package org.example;

import org.example.jframes.MainFrame;
import org.example.jframes.childs_mainframe.FixItemsUI;
import org.example.global_assets.ConsoleWindow;
import org.example.resource_loader_functions.Resource_GlobalVariables;

import javax.swing.*;

public class System_JFrameObjectHandler {
    /**
     * Stores all JFrame objects here so it can be easily controlled.
     * The main purpose of this class file is to be able to make class files across the program
     * to be capable of enabling/disabling visibility of jframes by access
     */
    public MainFrame mainFrameObj; // Holds the heart of the program. If this object dies somehow, most of the program will
    public FixItemsUI fixItemsUIObj;
    public ConsoleWindow _consoleWindowObj;

    public static System_JFrameObjectHandler mainObj = new System_JFrameObjectHandler(); // Mainly used to be able to create a non-static MainFrame object using SwingUtilities.invokeLater();

    /**
     * For running the main gui JFrame in an invokeLater method
     */
    public void swingUtilitiesInvokeLater() {
        SwingUtilities.invokeLater(() -> {
            this.mainFrameObj = new MainFrame();
                this.fixItemsUIObj = new FixItemsUI();
                this._consoleWindowObj = new ConsoleWindow();
        }
        );
    }

    /**
     * Mainly used to "name" JFrame objects so it can be used properly in changeOpenedJFrame function
     */
    public enum JFRAMES {
        MAIN_FRAME,
        FIX_ITEMS_UI,
        CONSOLE_WINDOW
    }

    /**
     * TLDR: hides the previous ui and shows the selected ui while centering
     * both jframes and recording the value of the newly selected ui
     */
    public static void changeOpenedJFrame (JFRAMES ui) {
        fetchVariable(Resource_GlobalVariables.currentlyOpenedJFrame).setVisible(false);
        fetchVariable(Resource_GlobalVariables.currentlyOpenedJFrame).setLocationRelativeTo(null);
        fetchVariable(ui).setLocationRelativeTo(null);
        fetchVariable(ui).setVisible(true);
        Resource_GlobalVariables.currentlyOpenedJFrame = ui;
    }

    /**
     * For utilizing enums and reducing possible code reuse<br>
     * Q : Why the heck do you even need this when you can just write 2 switch-cases? Is it because of code duplication issues?<br>
     * A : I have a shit brain and as the program grows, I might forget to write some enums in the switch case. So the best option really is this. And also super easy to track the stuff<br>
     */
    public static JFrame fetchVariable(JFRAMES value) {
        switch (value) {
            case MAIN_FRAME -> {
                return mainObj.mainFrameObj;
            }
            case FIX_ITEMS_UI -> {
                return mainObj.fixItemsUIObj;
            }
            case CONSOLE_WINDOW -> {
                return mainObj._consoleWindowObj;
            }
            default -> {
                return mainObj.mainFrameObj;
            }
        }
    }



}