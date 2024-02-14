package com.prototypage.calendrierduceri.controller;

import com.prototypage.calendrierduceri.Calendrier;
import com.prototypage.calendrierduceri.db.User;
import com.prototypage.calendrierduceri.db.UserDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.SQLException;

public class HelloController {

@FXML
public void initialize(){
        try (Connection conn = Calendrier.getDatabaseConnection()) {
            if (conn != null) {
                UserDaoImpl utilisateurDao = new UserDaoImpl(conn);
                User utilisateur = utilisateurDao.getUtilisateur("nabil", "nabilbed");
                if (utilisateur != null) {
                    System.out.println("bonjour  "+utilisateur.getPrenom());
                } else {
                    System.out.println("utilisateur non trouve");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données: " + e.getMessage());
        }
    }
}