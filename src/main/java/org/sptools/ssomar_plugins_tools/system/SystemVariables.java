package org.sptools.ssomar_plugins_tools.system;

import javafx.scene.control.TextArea;

import java.util.ArrayList;

/**
 * Any variables that may or will be required by the entire program as it
 * runs will be placed here. It may bound to be edited as the program runs.
 */
public class SystemVariables {
    /**
     * Mainly will be used by such features like
     * ConsoleWindow to figure out which scene to go back to
     * when returning.
     */
    public static String previousMenuPath;

    /**
     * Used to identify what folder got selected for editing item configs
     */
    public static String selectedDirectory;

    /**
     * Stores the file paths to the valid yml files so the job classes
     * can properly perform their tasks
     */
    public static ArrayList<String> validYMLFilesPaths;

    /**
     * External classes have to be the one to modify this value so the classes would know which
     * instance of the Control object needs to be touched to apply changes to the console.
     */
    public static TextArea outputFieldPointer;
}
