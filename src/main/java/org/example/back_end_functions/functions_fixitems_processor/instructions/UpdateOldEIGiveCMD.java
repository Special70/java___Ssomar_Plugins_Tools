package org.example.back_end_functions.functions_fixitems_processor.instructions;

import org.example.back_end_functions.FixItems_Processor;
import org.example.global_assets.ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <h1>WIP : DO NOT FULLY USE YET!</h1>
 */
public class UpdateOldEIGiveCMD {

    private static void consoleLog(String value) {
        ConsoleWindow_Attributes.consoleWindowOutput.append(value+"\n");
        ConsoleWindow_Attributes.consoleWindowOutput.setCaretPosition(
                ConsoleWindow_Attributes.consoleWindowOutput.getDocument().getLength()
        );
    }

    public static void executeTask() {

        // BIG O Formula = number_of_validated_files * number_of_activators (typically 1-5) * number_of_commands (typically 10-200)
        try {

            for (int i = 0; i < FixItems_Processor.validYmlFilePaths.size(); i++) {



            }
        } catch (Exception e) {}

    }
}
