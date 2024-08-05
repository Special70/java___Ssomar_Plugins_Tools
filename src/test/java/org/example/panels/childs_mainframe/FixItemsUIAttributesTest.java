package org.example.panels.childs_mainframe;

import li.flor.nativejfilechooser.NativeJFileChooser;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

class FixItemsUIAttributesTest {
    @Test
    void jfileChooser() {
        JFileChooser fileChooser = new NativeJFileChooser();
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