package org.example.panels.childs_mainframe;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

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

}