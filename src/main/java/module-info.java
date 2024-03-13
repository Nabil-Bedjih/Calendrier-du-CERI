module com.example.calendrier {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calendrier to javafx.fxml;
    exports com.example.calendrier;
}