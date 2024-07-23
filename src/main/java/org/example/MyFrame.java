package org.example;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JLabel label;
    MyFrame() {
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        this.add(createBorderedPanel(BorderFactory.createRaisedBevelBorder(),       "BEVEL BORDER (DEFAULT: RAISED)")); // DEFAULT = BevelBorder.RAISED
        this.add(createBorderedPanel(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "BEVEL BORDER LOWERED"));
        this.add(createBorderedPanel(BorderFactory.createCompoundBorder(
                BorderFactory.
                    createBevelBorder(BevelBorder.RAISED),
                    BorderFactory.createBevelBorder(BevelBorder.LOWERED)), "BEVEL BORDER RAISED AND LOWERED"));
        this.add(createBorderedPanel(BorderFactory.createEmptyBorder(10, 10, 10, 10), "EMPTY BORDER"));
        this.add(createBorderedPanel(BorderFactory.createEtchedBorder(), "ETCHED BORDER (DEFAULT: LOWERED)"));
        this.add(createBorderedPanel(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "ETCHED BORDER RAISED"));
        this.add(createBorderedPanel(BorderFactory.createEtchedBorder(Color.PINK, Color.RED), "ETCHED BORDER PINK RED"));
        this.add(createBorderedPanel(BorderFactory.createLineBorder(Color.red), "LINE BORDER RED"));
        this.add(createBorderedPanel(BorderFactory.createLineBorder(Color.blue, 5), "LINE BORDER BLUE THICK:5"));
        this.add(createBorderedPanel(BorderFactory.createDashedBorder(null), "DASHED BORDER"));
        this.add(createBorderedPanel(BorderFactory.createMatteBorder(1, 5, 3, 1, Color.blue), "MATTE BORDER")); // Can use images as border color and thickness of any of the 4 sides are customizable
        this.add(createBorderedPanel(BorderFactory.createTitledBorder("Title"), "TITLE BORDER"));

        this.setVisible(true);
    }

    public JPanel createBorderedPanel(Border b, String text) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(text);

        label.setBorder(b);
        panel.add(label);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(run);
        /*
Swing objects are not thread safe. SwingUtilities.invokeLater()
 allows a task to be executed at some later point in time, as the
  name suggests; but more importantly, the task will be executed
   on the AWT event dispatch thread. When using invokeLater, the
    task is executed asynchronously; there's also invokeAndWait,
     which won't return until the task has finished executing.
        * */
    }

    static Runnable run = new Runnable() {
        @Override
        public void run() {
            new MyFrame();
        }
    };
}
