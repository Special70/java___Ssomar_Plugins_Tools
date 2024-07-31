package org.example.panels.childs_mainframe;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

class FixItemsUIAttributesTest {
    @Test
    void checkFiles0() {

        try {
            StringBuilder customString = new StringBuilder();
            FileReader targetFile = new FileReader("src/test/java/org/example/panels/childs_mainFrame/testFiles/sangwoo.yml");
            while (targetFile.ready()) {
                customString.append((char) targetFile.read());
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkFiles1() {
        try {
            StringBuilder customString = new StringBuilder();
            File targetFile = new File("src/test/java/org/example/panels/childs_mainFrame/testFiles/sangwoo.yml");
            Scanner myReader = new Scanner(targetFile);
            while (myReader.hasNextLine()) {
                customString.append(myReader.nextLine());
            }
            myReader.close();

            String customString1 = customString.toString().replaceAll("(?<!minecraft:)tp", "gooning");
            System.out.println(customString1);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void iterateThroughEachFile() {
        File dir = new File("src/test/java/org/example/panels/childs_mainFrame/testFiles/items/");
        File[] directoryListing = dir.listFiles();

        Pattern pattern1 = Pattern.compile(".*\\.(yml)");

        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (pattern1.matcher(child.getPath()).find()) {
                    Yaml yaml = new Yaml();
                    try (InputStream inputStream = new FileInputStream(child.getPath())) {
                        Map<String, Object> data = yaml.load(inputStream);
                        // Validate data here
                        String dummy = String.valueOf(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // Handle the case where dir is not really a directory.
            // Checking dir.isDirectory() above would not be sufficient
            // to avoid race conditions with another process that deletes
            // directories.
        }
    }
}