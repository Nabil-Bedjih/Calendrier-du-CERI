package com.prototypage.calendrierduceri.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl {

    private Connection conn;
    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }


    public User getUtilisateur(String prenom,String motdepasse) {
        String sql = "SELECT  id,nom, prenom,motdepasse FROM users WHERE prenom = ? AND motdepasse = ?";
        User utilisateur  = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, prenom);
            pstmt.setString(2, motdepasse);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    utilisateur = new User();
                    utilisateur.setId(rs.getInt("id"));
                    utilisateur.setNom(rs.getString("nom"));
                    utilisateur.setPrenom(rs.getString("prenom"));
                    utilisateur.setMotdepasse(rs.getString("motdepasse"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de l utilisateur: " + e.getMessage());
        }
        return utilisateur;
    }


}
