package com.prototypage.calendrierduceri.controller;

import com.prototypage.calendrierduceri.Calendrier;
import com.prototypage.calendrierduceri.db.User;
import com.prototypage.calendrierduceri.db.UserDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    public void getConnection() {
        try (Connection conn = Calendrier.getDatabaseConnection()) {
            if (conn != null) {
                UserDaoImpl utilisateurDao = new UserDaoImpl(conn);
                User user = utilisateurDao.getUtilisateur(usernameField.getText(), passwordField.getText());
                if (user != null) {
                    System.out.println("connection successful  "+user.getPrenom());
                    Calendrier.getConnectionView();
                } else {
                    System.out.println("Incorrect username or password");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error to get connection at the database: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
