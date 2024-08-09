package org.example.resource_loader_functions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Resource_Images {
    /**
     * @return Image of the program's icon
     */
    public static ImageIcon getImage(String fileName) {
        try {
            InputStream is = Resource_Images.class.getResourceAsStream(fileName);
            if (is != null) {
                BufferedImage image = ImageIO.read(is);
                ImageIcon imageIcon = new ImageIcon(image);
                return imageIcon;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }
}
