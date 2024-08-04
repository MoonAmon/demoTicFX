module application {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens application to javafx.fxml;
    opens org.example.demoticfx to javafx.fxml;
    exports org.example.demoticfx;
    exports application;

}