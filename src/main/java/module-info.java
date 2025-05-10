module org.example.ssomar_plugins_tools {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens org.example.ssomar_plugins_tools to javafx.fxml;
    exports org.example.ssomar_plugins_tools;
}