package org.example.global_assets;


import javax.swing.*;
import java.awt.*;

public class ConsoleWindow_Attributes extends JPanel {
    public static JTextArea consoleWindowOutput = new JTextArea("", 10, 10);
    private JScrollPane consoleWindowPane = new JScrollPane(consoleWindowOutput);

    public ConsoleWindow_Attributes() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBounds(125, 80, 1250, 800);
        this.setLayout(new GridLayout(1, 1, 0, 0));

        consoleWindowOutput.setEditable(false);

        consoleWindowPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        consoleWindowPane.setLayout(new ScrollPaneLayout());
        this.add(consoleWindowPane);
    }
}
