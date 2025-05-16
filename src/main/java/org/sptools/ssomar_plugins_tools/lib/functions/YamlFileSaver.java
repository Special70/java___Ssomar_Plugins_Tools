package org.sptools.ssomar_plugins_tools.lib.functions;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class YamlFileSaver {
    public static void saveChanges(String path, Map<String, Object> yamlFile, FileWriter writerArg) {
        try {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yamlDumper = new Yaml(options);

            // Write the modified data back to the YAML file
            yamlDumper.dump(yamlFile, writerArg);
            // Done
        } catch (Exception e) {}
    }
}
