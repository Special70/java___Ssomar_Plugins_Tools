package org.example;

import org.example.jframes.MainFrame;
import org.example.jframes.childs_mainframe.FixItemsUI;
import org.example.jframes.childs_mainframe.childs_fixitemsui.FixItemsUI_ConsoleWindow;
import org.example.resource_loader_functions.Resource_GlobalVariables;

import javax.swing.*;

public class JFrameObjectHandler {
    // Stores all JFrame objects here so it can be easily controlled.
    // The main purpose of this class file is to be able to make class files across the program
    // to be capable of enabling/disabling visibility of jframes by access
    public MainFrame mainFrameObj; // Holds the heart of the program. If this object dies somehow, most of the program will
    public FixItemsUI fixItemsUIObj;
    public FixItemsUI_ConsoleWindow fixItemsUI_consoleWindowObj;

    public static JFrameObjectHandler mainObj = new JFrameObjectHandler(); // Mainly used to be able to create a non-static MainFrame object using SwingUtilities.invokeLater();

    public void swingUtilitiesInvokeLater() {  // For running the main gui JFrame in an invokeLater method
        SwingUtilities.invokeLater(() -> {
            this.mainFrameObj = new MainFrame();
                this.fixItemsUIObj = new FixItemsUI();
                this.fixItemsUI_consoleWindowObj = new FixItemsUI_ConsoleWindow();
        }
        );
    }

    public enum JFRAMES {
        MAIN_FRAME,
        FIX_ITEMS_UI,
        FIX_ITEMS_UI_CONSOLE_WINDOW
    }




    public void changeOpenedJFrame (JFRAMES ui) {
        // TLDR: hides the previous ui and shows the selected ui while centering
        // both jframes and recording the value of the newly selected ui
        fetchVariable(Resource_GlobalVariables.currentlyOpenedJFrame).setVisible(false);
        fetchVariable(Resource_GlobalVariables.currentlyOpenedJFrame).setLocationRelativeTo(null);
        fetchVariable(ui).setLocationRelativeTo(null);
        fetchVariable(ui).setVisible(true);
        Resource_GlobalVariables.currentlyOpenedJFrame = ui;
    }

    public JFrame fetchVariable(JFRAMES value) { // For utilizing enums and reducing possible code reuse
        // Q : Why the heck do you even need this when you can just write 2 switch-cases? Is it because of code duplication issues?
        // A : I have a shit brain and as the program grows, I might forget to write some enums in the switch case. So the best option really is this. And also super easy to track the stuff
        switch (value) {
            case MAIN_FRAME -> {
                return this.mainFrameObj;
            }
            case FIX_ITEMS_UI -> {
                return this.fixItemsUIObj;
            }
            case FIX_ITEMS_UI_CONSOLE_WINDOW -> {
                return this.fixItemsUI_consoleWindowObj;
            }
            default -> {
                return this.mainFrameObj;
            }
        }
    }



}