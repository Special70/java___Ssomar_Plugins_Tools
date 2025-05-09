package org.example;

import org.example.back_end_functions.functions_fixitems_processor.string_modification_functions.UpdateOldEIGiveCMD;
import org.example.resource_loader_functions.Resource_Lang;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.List;
import java.util.Map;


public class Testing_Grounds {
    @Test
    public void runTest() {

        UpdateOldEIGiveCMD.executeTask("ei giveslot %player% Attribute_Item 1 %slot% Var(uuid:%rand:1|10000000%-%rand:1|1000%-%rand:2|1000%-%rand:3|1000%-%rand:2|10000000%,foo:bar) Usage(5)");
    }

    @Test
    public void runYAMLTest() {
        try {
            String inputValue = "nous";
            InputStream resourceStream = Resource_Lang.class.getResourceAsStream("/runner/otheroptions/yaml_env.yml");

            Map<String, Object> loadedYMLFile = null;
            Yaml yaml = new Yaml();
            loadedYMLFile = yaml.load(resourceStream); // Load file
            List<String> valuesList = (List<String>) loadedYMLFile.get("values");

            valuesList.clear(); // Wipes current content
            valuesList.add(inputValue); // adds the content that exists in the input box

            // DUMPER
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yamlDumper = new Yaml(options);

            // Write the modified data back to the YAML file
            FileWriter writer = new FileWriter(new File("/runner/otheroptions/yaml_env.yml")); // Replaces the current file
            yamlDumper.dump(loadedYMLFile, writer);

            // Time to read the thing

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Process the line
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
    }

}
