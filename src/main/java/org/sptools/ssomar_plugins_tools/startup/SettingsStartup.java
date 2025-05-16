package org.sptools.ssomar_plugins_tools.startup;

import javafx.application.Platform;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.sptools.ssomar_plugins_tools.lib.ReusableFunctions;

public class SettingsStartup {

    public SettingsStartup() {

        Font.loadFont(getClass().getResourceAsStream("/fonts/MinecraftRegular-Bmg3.otf"), 12);
    }
}
