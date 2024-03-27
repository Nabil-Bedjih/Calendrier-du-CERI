module com.prototypage.calendrierduceri {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires ical4j;
    requires java.mail;

    opens com.prototypage.calendrierduceri to javafx.fxml;
    exports com.prototypage.calendrierduceri;
    exports com.prototypage.calendrierduceri.controller;
    opens com.prototypage.calendrierduceri.controller to javafx.fxml;
}