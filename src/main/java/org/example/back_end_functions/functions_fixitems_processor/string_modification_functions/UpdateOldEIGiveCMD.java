package org.example.back_end_functions.functions_fixitems_processor.string_modification_functions;

import org.example.back_end_functions.functions_fixitems_processor.string_modification_functions.sub_functions.ReplaceColonSymbolInPlaceholders;
import org.example.global_assets.ConsoleWindow_Attributes;

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

    public static void executeTask(String value) {


        try {
            /**
             * Sample patterns that it checks for:
             * ei giveslot %player% Attribute_Item 1 %slot% Var(uuid:%rand:1|10000000%-%rand:1|1000%-%rand:2|1000%-%rand:3|1000%-%rand:2|10000000%)
             *       Usage(5) +++ ei giveslot %player% Attribute_Item 1 %slot% Var(uuid:%rand:1|10000000%-%rand:1|1000%-%rand:2|1000%-%rand:3|1000%-%rand:2|10000000%)
             *       Usage(5)
             * ei giveslot %player% Attribute_Item 1 %slot% Var(uuid:%rand:1|10000000%-%rand:1|1000%-%rand:2|1000%-%rand:3|1000%-%rand:2|10000000%) Usage(5)
             * ei give %player% foobar 1 %slot% VAR(key:var, foo:bar) USAGE(123)
             */
            Matcher matchFinder = Pattern.compile("ei\\s+(giveslot|give)\\s+[%\\w]+\\s+[%\\w]+\\s+\\d+\\s+[%\\w]+\\s+[VARUSAGEvarusage]+(\\(.*?\\))(?=\\s+\\+\\+\\+|$)")
                    .matcher(value);

            HashSet<String> foundPatterns = new HashSet<>(); // Saves found unique patterns

            while (matchFinder.find()) { // Finds unique patterns
                System.out.println(matchFinder.group());
                foundPatterns.add(matchFinder.group());
            }

            if (foundPatterns.isEmpty()) return; // Terminate task if no patterns found

            /*
             Otherwise, continue
             Starting from here, when reading this code, forget about what's written above.
             Regarding about the patterns, it's already dealt with nicely.

             This for loop iterates through each ei give/giveslot it finds
            */
            for (String targetPatterns : foundPatterns) {

                // Stores the info found in the target pattern
                String usageDetails = null; // Stores the info
                ArrayList< String[] > varDetails = new ArrayList<>();

                /**
                 * Then: ei giveslot %player% Attribute_Item 1 %slot% Var(one:two,two:three) Usage(5)
                 */
                String[] commandDetails = targetPatterns.split(" ");

                for (int iteration_commandDetails = 0; iteration_commandDetails < commandDetails.length; iteration_commandDetails++) {
                    if (commandDetails[iteration_commandDetails].toUpperCase().contains("VAR")) {
                        /**
                         * The contents of VAR() contains a key:value pair separated by ","
                         * meaning that the values must be stored in a key:value format
                         */
                        String keyValuePairs = commandDetails[iteration_commandDetails].split("\\(|\\)")[1]; // Extracts the contents of VAR() and is stored in this variable
                        /**
                         * Contains String[]{key, value} pairs
                         */
                        varDetails = ReplaceColonSymbolInPlaceholders.executeTask(keyValuePairs); // View the function to see what it does

                        commandDetails[iteration_commandDetails] = null; // Bricks the command section so it can be ignored
                    } else if (commandDetails[iteration_commandDetails].toUpperCase().contains("USAGE")) {
                        usageDetails = commandDetails[iteration_commandDetails].split("\\(|\\)")[1]; // Splits the "USAGE(5)" details and gets the first argument
                        commandDetails[iteration_commandDetails] = null; // Bricks the command section so it can be ignored
                    }

                }

                // Start building the properties of the item id section
                String[] newIDFormatBuilder = new String[(usageDetails != null ? 1 : 0) + (!varDetails.isEmpty() ? 1 : 0)];
                int newIdFormatBuilder_indexToFill = 0;

                if (usageDetails != null) {
                    newIDFormatBuilder[newIdFormatBuilder_indexToFill] = "Usage:"+usageDetails; // Insert the details
                    newIdFormatBuilder_indexToFill++;
                }

                if (!varDetails.isEmpty()) {
                    StringBuilder wordBuilder = new StringBuilder();
                    wordBuilder.append("Variable:{");

                    // Code below adds all found key:value pairs in the intended format
                    for (String[] keyValuePairDetails : varDetails) {
                        wordBuilder.append(keyValuePairDetails[0])
                                .append(":")
                                .append(keyValuePairDetails[1])
                                .append(",");
                    }
                    wordBuilder.deleteCharAt(wordBuilder.length()-1); // Removes the comma at the last part

                    wordBuilder.append("}");
                    newIDFormatBuilder[newIdFormatBuilder_indexToFill] = wordBuilder.toString();
                }

                System.out.println("New ID String: {"+ Arrays.toString(newIDFormatBuilder).substring(
                        1, Arrays.toString(newIDFormatBuilder).length()-1
                )
                +"}");
            }
            // Forget about everything written above




        } catch (Exception ignored) {}

    }

}
