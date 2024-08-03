package org.example.panels.childs_mainframe;

import org.example.global_assets.ConsoleWindow;
import org.example.global_assets.ConsoleWindow_Attributes;
import org.example.resource_loader_functions.Resource_Lang;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestArea {


    private static void consoleLog(String value) {
        ConsoleWindow_Attributes.consoleWindowOutput.append(value+"\n");
        ConsoleWindow_Attributes.consoleWindowOutput.setCaretPosition(
                ConsoleWindow_Attributes.consoleWindowOutput.getDocument().getLength()
        );
    }

    @Test
    public void testcode() {

        try {
            // Reading yml files and saving it in a Map
            String path = "src/test/java/org/example/panels/childs_mainframe/testFiles/RAINBOW_COLORS_OF_BEAUTY.yml";
            InputStream inputStream = new FileInputStream(new File(path));
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);

            // Print the original data
            System.out.println("Original data: " + data);

            // Navigate to the "commands" list
            Map<String, Object> activators = (Map<String, Object>) data.get("activators"); // gets the properties of the "activators:" to get the child objects (activator0, activator1, ...)

            System.out.println("CHECKFOR : "+activators);

            for (Map.Entry<String, Object> foundActivators : activators.entrySet()) { // iterates through its child objects
                Map<String, Object> targetActivator = (Map<String, Object>) activators.get(foundActivators.getKey()); // saves the child object in a variable
                List<String> commandsOfTheActivator = (List<String>) targetActivator.get("commands"); // saves the command list of the child object to this variable

                for (int iterations = 0; iterations<commandsOfTheActivator.size(); iterations++) {
                    Set<String> foundPatterns = new HashSet<>(); // Store found patterns here
                    Matcher matchFinder = Pattern.compile("(dust)+\\s*(\\d*\\.*\\d*)\\s*(\\d*\\.*\\d*)\\s*(\\d*\\.*\\d*)\\s*(\\d*\\.*\\d*)")
                            .matcher(commandsOfTheActivator.get(iterations));

                    for (String i : foundPatterns) {
                        System.out.println(i);
                    }

                    while (matchFinder.find()) {
                        if (!matchFinder.group().trim().equals("dust")) {
                            foundPatterns.add(matchFinder.group().trim());
                        }
                    }

/*
                    consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ConvertDustCMDTo_1_20_5_patternCountInAFile")
                            .replace("%count%", String.valueOf(foundPatterns.size()))
                            .replace("%path%", path)
                    );*/

                    // Skipping the steps below if no patterns are found ==================================================================================================================================================
                    if (foundPatterns.isEmpty()) {
                        continue;
                    }

                    //consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ConvertDustCMDTo_1_20_5_startEditing").replace("%path%", path));


                    for (String foundPattern : foundPatterns) {

                        // Store the detected patterns into an array for further use
                        String[] patternDetails = foundPattern.split(" ");
                        // Converts the other values into double
                        double[] rgbSizeParameters = new double[]{
                                Double.parseDouble(patternDetails[1]),
                                Double.parseDouble(patternDetails[2]),
                                Double.parseDouble(patternDetails[3]),
                                Double.parseDouble(patternDetails[4])
                        };

                        String newParticleDustCommandFormat = (
                                "dust{color:["+
                                        rgbSizeParameters[0]+","+
                                        rgbSizeParameters[1]+","+
                                        rgbSizeParameters[2]+
                                        "],scale:"+rgbSizeParameters[3]+"}"
                        );
/*
                        consoleLog(Resource_Lang.langFile.getProperty("FixItems_Processor_ConvertDustCMDTo_1_20_5_commenceReplacingMsg")
                                .replace("%old%", foundPattern)
                                .replace("%new%", newParticleDustCommandFormat));*/

                        commandsOfTheActivator.set(iterations, commandsOfTheActivator.get(iterations).replace(foundPattern, newParticleDustCommandFormat));


                    }


                }
            }


            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yamlDumper = new Yaml(options);

            // Write the modified data back to the YAML file
            FileWriter writer = new FileWriter(new File(path));
            yamlDumper.dump(data, writer);

            // Print the modified data to the console
            String modifiedYaml = yamlDumper.dump(data);
            //System.out.println("Modified data: \n" + modifiedYaml);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
