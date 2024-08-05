package org.example;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import java.util.Scanner;

public class ValidateResourceGetter {
    @Test
    public void run() {
        try {

            InputStream is = ValidateResourceGetter.class.getResourceAsStream("/test.txt");
            Scanner s = new Scanner(is).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";

            System.out.println(result);


            System.out.println("File found");
        } catch (Exception e) {
            System.out.println("Target not found");

        }
    }
}
