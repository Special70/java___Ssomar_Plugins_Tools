package org.example.panels.childs_mainframe_fixitems;

import org.example.resource_loader_functions.Resource_Lang;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Selection_Functions extends JPanel implements ActionListener {
    public static JCheckBox button_specifyVanillaCommands = new JCheckBox(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_button-fixTPCommand"));

    public static JCheckBox button_convertDustCommandsTo_1_20_5 = new JCheckBox(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_button-convertDustCommandTo-1-20-5"));

    public static JCheckBox button_convertDustCommandsToPre_1_20_5 = new JCheckBox(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_button-convertDustCommandToPre-1-20-5"));

    public static JCheckBox button_updateOldEIGiveCMD = new JCheckBox(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_button-updateOldEIGiveCMD"));
    /**
     * Returns a boolean value depending if any of the checkboxes
     * are selected
     */
    public static boolean hasUserSelectedAnyOptions() {
        return button_specifyVanillaCommands.isSelected()
                || button_convertDustCommandsTo_1_20_5.isSelected()
                || button_convertDustCommandsToPre_1_20_5.isSelected();
    }

    public Selection_Functions() {
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20),
                BorderFactory.createTitledBorder(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_border"))
        ));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        button_convertDustCommandsTo_1_20_5.addActionListener(this);
        button_convertDustCommandsToPre_1_20_5.addActionListener(this);

        button_specifyVanillaCommands.setToolTipText(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_tooltip_specifyVanillaCommand"));
        button_convertDustCommandsTo_1_20_5.setToolTipText(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_tooltip_convertDustCommandTo-1-20-5"));
        button_convertDustCommandsToPre_1_20_5.setToolTipText(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_tooltip_convertDustCommandToPre-1-20-5"));
        button_updateOldEIGiveCMD.setToolTipText(Resource_Lang.langFile.getProperty("FixItemsUIAttributes_Selection-Functions_tooltip_updateOldEIGiveCMD"));

        this.add(button_specifyVanillaCommands);
        this.add(button_convertDustCommandsTo_1_20_5);
        this.add(button_convertDustCommandsToPre_1_20_5);
        this.add(button_updateOldEIGiveCMD);
    }

    /**
     * Q: Why the heck is this here? You said that all the action listeners are in
     * the JFrame java files!<br>
     * A: I believe this feature is better placed here as it's "technically" a "CSS+Javascript" in works.
     * meaning, it's just a design thing. Might be too much work to combine a jcheckbox and a jcombobox in a jpanel
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_convertDustCommandsTo_1_20_5) {
            if (button_convertDustCommandsToPre_1_20_5.isSelected()) {
                button_convertDustCommandsToPre_1_20_5.setSelected(false);
            }
        } else if (e.getSource() == button_convertDustCommandsToPre_1_20_5) {
            if (button_convertDustCommandsTo_1_20_5.isSelected()) {
                button_convertDustCommandsTo_1_20_5.setSelected(false);
            }
        }
    }
}
