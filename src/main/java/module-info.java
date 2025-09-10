module com.example.kursinis {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;

    opens com.example.kursinis to javafx.fxml;
    exports com.example.kursinis;
}