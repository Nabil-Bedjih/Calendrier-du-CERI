package com.example.calendrier;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalendarApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création de la fenêtre principale
        primaryStage.setTitle("Calendrier du CERI");

        // Création du menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("Fichier");
        MenuItem openItem = new MenuItem("Ouvrir");
        MenuItem saveItem = new MenuItem("Enregistrer");
        MenuItem exitItem = new MenuItem("Quitter");
        fileMenu.getItems().addAll(openItem, saveItem, new SeparatorMenuItem(), exitItem);
        menuBar.getMenus().add(fileMenu);

        // Création de la zone d'affichage des emplois du temps
        TextArea scheduleArea = new TextArea();
        scheduleArea.setEditable(false);

        // Création de la mise en page
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(scheduleArea);
        BorderPane.setMargin(menuBar, new Insets(10));
        BorderPane.setMargin(scheduleArea, new Insets(10));

        // Configuration de la scène
        Scene scene = new Scene(root, 800, 600);

        // Configuration de la fenêtre principale
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
