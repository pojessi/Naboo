module org.naboo.javaFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.rometools.rome;
    requires java.xml;


    opens org.naboo.javaFX to javafx.fxml;
    exports org.naboo.javaFX;
}