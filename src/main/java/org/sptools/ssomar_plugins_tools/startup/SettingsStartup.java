package org.sptools.ssomar_plugins_tools.startup;

import javafx.scene.text.Font;

public class SettingsStartup {
    public SettingsStartup() {
        Font.loadFont(getClass().getResourceAsStream("/fonts/MinecraftRegular-Bmg3.otf"), 12);
    }
}
