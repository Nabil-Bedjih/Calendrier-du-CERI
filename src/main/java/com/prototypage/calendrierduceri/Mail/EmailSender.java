package com.prototypage.calendrierduceri.Mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static void sendEmail(String host, String port, final String username, final String password, String recipientEmail, String subject, String messageContent) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.ssl.trust", host); // Nécessaire pour les serveurs qui utilisent des certificats auto-signés

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(messageContent);

            Transport.send(message);

            System.out.println("E-mail envoyé avec succès.");

        } catch (MessagingException e) {
            System.out.println("Erreur lors de l'envoi de l'e-mail : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "nabil.bedjih10@gmail.com";
        String password = "bnih miiw tfcp rpap";
        String recipientEmail = "nabil.bedjih@alumni.univ-avignon.fr";
        String subject = "alerte";
        String messageContent = "ceci est un test";

        sendEmail(host, port, username, password, recipientEmail, subject, messageContent);
    }
}
