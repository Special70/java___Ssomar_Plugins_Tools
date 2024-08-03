package org.example.panels.childs_mainframe;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class WorkingFile_ForReadingYMLFiles {
    public static void main(String[] args) {
        try {
            // Reading yml files and saving it in a Map
            String path = "src/test/java/org/example/panels/childs_mainframe/testFiles/RAINBOW_TERRARIUS_SABER.yml";
            InputStream inputStream = new FileInputStream(new File(path));
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);

            // Print the original data
            System.out.println("Original data: " + data);

            // Navigate to the "commands" list
            Map<String, Object> activators = (Map<String, Object>) data.get("activators"); // grabs the "activators:" key
            Map<String, Object> activator0 = (Map<String, Object>) activators.get("activator0"); // grabs the "activator0:" key
            List<String> commands = (List<String>) activator0.get("commands"); // Contains the commands-to-edit (you obtain the reference towards the commands section not the copy)

            commands.clear(); // since you have the reference, clearing this actually clears the content

            // Print the original commands
            System.out.println("Original commands: " + commands);

            // Modify the commands list
            commands.add("for sure");

            // Print the modified commands
            System.out.println("Modified commands: " + commands);

            // Print the modified data
            System.out.println("Modified data: " + data);

            // Next 3 code lines makes sure that the key("commands") has its values in a " -" list
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
