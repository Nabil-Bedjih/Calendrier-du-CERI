module com.prototypage.calendrierduceri {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.prototypage.calendrierduceri to javafx.fxml;
    exports com.prototypage.calendrierduceri;
}