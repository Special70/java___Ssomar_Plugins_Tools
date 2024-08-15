package org.example.back_end_functions.functions_fixitems_processor.sub_functions;

import org.example.back_end_functions.FixItems_Processor;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class YamlFileSaver {
    public static void saveChanges(String path, Map<String, Object> yamlFile) {
        try {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yamlDumper = new Yaml(options);

            // Write the modified data back to the YAML file
            FileWriter writer = new FileWriter(new File(path)); // Replaces the current file by first targeting the file path
            yamlDumper.dump(yamlFile, writer);
            // Done
        } catch (Exception e) {}
    }
}
