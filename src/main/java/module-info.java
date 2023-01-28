module com.example.proiect {
    requires javafx.controls;
    requires javafx.fxml;


    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;
    requires org.testng;
    requires org.junit.jupiter.api;
    requires junit;

    opens com.example.proiect to javafx.fxml;
    exports com.example.proiect;
}