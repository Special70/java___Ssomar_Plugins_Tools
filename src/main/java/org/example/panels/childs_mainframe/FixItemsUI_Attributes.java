package org.example.panels.childs_mainframe;

import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.*;

public class FixItemsUI_Attributes extends JPanel {
    public static JButton startButton = new JButton(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_startButton"));
    public FixItemsUI_Attributes() {
        this.setBounds(100, 100, 800, 600);
        this.setBorder(BorderFactory.createDashedBorder(null));
        this.setLayout(new GridLayout(2, 1, 20, 20));
            this.add(new Selection_Functions());
            startButton.setToolTipText(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_startButtonToolTip"));
            this.add(startButton);
    }
}

