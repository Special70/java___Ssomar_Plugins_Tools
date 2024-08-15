package org.example.back_end_functions.functions_fixitems_processor.sub_functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivatorCommandsReader {
    public static ArrayList< List<String> > executeTask(Map<String, Object> yamlFile) {

        Map<String, Object> activators = (Map<String, Object>) yamlFile.get("activators"); // Grabs all child keys from the "activator" key

        ArrayList< List<String> > listOfCommands = null; // Contains List<String> objects that contain the commands that are to-be-edited

        for (Map.Entry<String, Object> foundActivators : activators.entrySet()) {
            Map<String, Object> targetActivator = (Map<String, Object>) activators.get(foundActivators.getKey()); // saves the child object in a variable

            // Mainly deal with this. It contains the words that are meant to be edited
            List<String> commandsOfTheActivator = (List<String>) targetActivator.get("commands"); // saves the command list of the child object to this variable

            listOfCommands.add(commandsOfTheActivator); // Adds commands-to-be-edited in this ArrayList
        }

        return listOfCommands;
    }
}
