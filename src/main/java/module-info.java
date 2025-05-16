module org.sptools.ssomar_plugins_tools {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.desktop;
    requires org.yaml.snakeyaml;

    opens org.sptools.ssomar_plugins_tools to javafx.fxml;
    exports org.sptools.ssomar_plugins_tools;
    exports org.sptools.ssomar_plugins_tools.controllers;
    opens org.sptools.ssomar_plugins_tools.controllers to javafx.fxml;
    exports org.sptools.ssomar_plugins_tools.lib;
    opens org.sptools.ssomar_plugins_tools.lib to javafx.fxml;
    exports org.sptools.ssomar_plugins_tools.startup;
    opens org.sptools.ssomar_plugins_tools.startup to javafx.fxml;
}