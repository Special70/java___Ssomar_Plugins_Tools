package org.example.back_end_functions.functions_fixitems_processor.string_modification_functions.sub_functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReplaceColonSymbolInPlaceholders {

    private static boolean isColonInsidePlaceholder = false;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static ArrayList<String> temp_keyValuePairHolder = new ArrayList<>(); // Temporarily stores the key:value pairs it finds. If the key:value pair is completed, the values are transferred to another arraylist variable
    private static ArrayList<String[]> keyValuePairHolder = new ArrayList<>(); // Saves the found key:value pairs here

    /**
     * <h1>How this works:</h1>
     * This function accepts a string value (usually the contents of VAR()
     *
     */
    public static ArrayList<String[]> executeTask(String value) {
        // Reads the string char-by-char
        for (int i = 0; i < value.length(); i++) {
            // Toggles the boolean value depending whether the program is inside of a placeholder or not while reading
            if (value.charAt(i) == '%') {
                isColonInsidePlaceholder = !isColonInsidePlaceholder;
            }
            // Transfers the contents of the stringBuilder to a function that properly handles said values
            if ((value.charAt(i) == ':' || value.charAt(i) == ',') && !isColonInsidePlaceholder) {
                System.out.println("Exporing : "+stringBuilder);
                appendString(stringBuilder.toString());
                continue;
            }

            stringBuilder.append( value.charAt(i) );

        }
        if (!stringBuilder.isEmpty()) {
            System.out.println("Exporing : "+stringBuilder);
            appendString(stringBuilder.toString());
        }


        ArrayList<String[]> returnArrayList = keyValuePairHolder;
        System.out.println(
                Arrays.toString(returnArrayList.get(0))
        );

        return returnArrayList;
    }

    /**
     * <h1>How this works:</h1>
     * A value would be added to the {@link ReplaceColonSymbolInPlaceholders#temp_keyValuePairHolder} variable upon executing this function.
     * Afterwards, it resets the contents of the {@link ReplaceColonSymbolInPlaceholders#stringBuilder} so it can be reused for further use.
     * If {@link ReplaceColonSymbolInPlaceholders#temp_keyValuePairHolder} contains 2 values, that means it manages to capture a key:value pair,
     * therefor, its contents would be transferred to {@link ReplaceColonSymbolInPlaceholders#keyValuePairHolder} while the contents of
     * {@link ReplaceColonSymbolInPlaceholders#temp_keyValuePairHolder} would be wiped so it can be reused.
     */
    public static void appendString(String value) {
        temp_keyValuePairHolder.add(value);
        stringBuilder.setLength(0); // Resetting the
        if (temp_keyValuePairHolder.size() == 2) {
            keyValuePairHolder.add(new String[]{
                    temp_keyValuePairHolder.get(0),
                    temp_keyValuePairHolder.get(1)
            });
            temp_keyValuePairHolder.clear();
        }
    }

    public static void main(String[] args) {
        executeTask("uuid:%rand:1|10000000%-%rand:1|1000%-%rand:2|1000%-%rand:3|1000%-%rand:2|10000000%");
    }
}
