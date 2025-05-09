package org.example.panels.childs_mainframe_fixitems;

import org.example.global_assets.GlobalFunctions;
import org.example.resource_loader_functions.Resource_GlobalVariables;
import org.example.resource_loader_functions.Resource_Lang;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.awt.GridLayout;
import java.io.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Map;

public class OtherOptionsUI_Attributes extends JPanel {
    private JTextArea inputbox = new JTextArea();
    private JTextArea outputBox = new JTextArea();

    public OtherOptionsUI_Attributes() {
        this.setBounds(100, 100, 800, 600);
        this.setBorder(BorderFactory.createDashedBorder(null));
        this.setLayout(new GridLayout(4, 1, 20, 20));

        this.add(GlobalFunctions.createLabel("Type normal string below", 20));
        this.add(inputbox);

        this.add(GlobalFunctions.createLabel("Output below", 20));
        outputBox.setEditable(false);
        this.add(outputBox);

        inputbox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    private void handleChange() {
        String inputValue = inputbox.getText();
        try (InputStream inputStream = new FileInputStream(Resource_GlobalVariables.selectedFilePath)) {
            Yaml yaml = new Yaml();
            Map<String, Object> loadedYMLFile = null;
            loadedYMLFile = yaml.load(inputStream); // Load file

            // Modify content
            Map<String, Object> activators = (Map<String, Object>) loadedYMLFile.get("activators");
            Map<String, Object> activators0 = (Map<String, Object>) activators.get("activator0");
            List<String> valuesList = (List<String>) activators0.get("commands");
            valuesList.clear(); // Wipes current content
            valuesList.add(inputValue); // adds the content that exists in the input box

            // Dumper
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yamlDumper = new Yaml(options);


            // Write the modified data back to the YAML file
            try (FileWriter writer = new FileWriter(Resource_GlobalVariables.selectedFilePath)) {
                yamlDumper.dump(loadedYMLFile, writer);
                System.out.println("YAML file updated successfully!");
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(Resource_GlobalVariables.selectedFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Process the line
                }
            } catch (IOException e) {
                e.printStackTrace();
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
