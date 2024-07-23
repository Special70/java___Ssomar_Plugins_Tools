package org.example;

import javax.swing.*;

public class MyTableFrame extends JFrame {

    MyTableFrame() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[][] data = {
                {"apple", "banana", "carrot"},
                {"axolotl", "bird", "cat"}
        };
        String[] columnNames = {
                "a", "b"
        };

        JTable table = new JTable(data, columnNames);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(run);
    }

    static Runnable run = new Runnable() {
        @Override
        public void run() {
            new MyTableFrame();
        }
    };
}
