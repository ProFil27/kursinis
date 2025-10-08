module com.example.kursinis {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;
    requires javafx.graphics;

    opens com.example.kursinis to javafx.fxml;
    exports com.example.kursinis;
    opens com.example.kursinis.fxControllers to javafx.fxml;
    exports com.example.kursinis.fxControllers;

}