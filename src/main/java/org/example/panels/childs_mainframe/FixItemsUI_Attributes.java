package org.example.panels.childs_mainframe;

import org.example.JFrameObjectHandler;
import org.example.back_end_functions.FixItems_Processor;
import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FixItemsUI_Attributes extends JPanel implements ActionListener {
    private JButton startButton = new JButton(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_startButton"));
    public FixItemsUI_Attributes() {
        this.setBounds(100, 100, 800, 600);
        this.setBorder(BorderFactory.createDashedBorder(null));
        this.setLayout(new GridLayout(2, 1, 20, 20));
            this.add(new Selection_Functions());
            this.startButton.setToolTipText(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_startButtonToolTip"));
            this.startButton.addActionListener(this);
            this.add(startButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            JFrameObjectHandler.changeOpenedJFrame(JFrameObjectHandler.JFRAMES.FIX_ITEMS_UI_CONSOLE_WINDOW);
            FixItems_Processor.staticObj.start();
        }
    }
}

