package com.project.service;

import com.project.clinic.PasswordResetToken;
import com.project.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Service
public class PasswordResetService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    public PasswordResetService(PasswordResetTokenRepository passwordResetTokenRepository) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    public Optional<PasswordResetToken> getTokenByEmail(String email) {
        try {
            if (email == null) {
                throw new IllegalArgumentException("PasswordResetService: incorrect email");
            }
            return passwordResetTokenRepository.findByEmailToReset(email);
        } catch (Exception e) {
            System.err.println("Error retrieving code by email: " + e.getMessage());
            throw e;
        }
    }

    public void initiatePasswordReset(String email) {
        String verificationCode = generateVerificationCode();

        PasswordResetToken token = new PasswordResetToken();
        token.setEmailToReset(email);
        token.setToken(verificationCode);
        passwordResetTokenRepository.save(token);

        sendPasswordResetEmail(email, verificationCode);
    }

    private String generateVerificationCode() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private void sendPasswordResetEmail(String email, String verificationCode) {
        System.out.println("code sending activated");

        final String senderEmail = "afwork@wp.pl";
        final String password = "Abpf.123456";

        String host = "smtp.wp.pl";
        int port = 465;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.enable", "true"); // Enable SSL
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        });
        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Password Reset Verification Code");
            message.setText("Your password reset verification code is: " + verificationCode);

            Transport.send(message);

            System.out.println("Password reset verification code sent successfully to " + email);
        } catch (MessagingException e) {
            System.out.println("Error occurred while sending email: " + e.getMessage());
        }
    }


    public void sendEmail(String email, String imie, String phone, String text) {
        System.out.println("email sending activated");
        // Sender's email address
        final String senderEmail = "gabinetrehabinfo@gmail.com";
        // Sender's email password
        final String password = "fodu gdje zisb inak";

        // SMTP server details
        String host = "smtp.gmail.com";
        int port = 587;

        // Create properties for the SMTP session
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Create a Session object with the properties and authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        });

        // Used to debug SMTP issues
        // session.setDebug(true);

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);
            // Set sender email address
            message.setFrom(new InternetAddress(senderEmail));
            // Set recipient email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(senderEmail));
            // Set email subject
            message.setSubject("Contact from client - " + email);
            // Set email content
            message.setText(imie + ": " + text + ", " + phone);

            // Send the email
            Transport.send(message);

            System.out.println("Email delivered successfully from " + email);
        } catch (MessagingException e) {
            System.out.println("Error occurred while sending email: " + e.getMessage());
        }
    }
}
    /*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken();
        myToken.setToken(token);
        myToken.setUser(user);
        myToken.setExpiryDate(new Date(System.currentTimeMillis() + 3600000)); // 1 hour
        tokenRepository.save(myToken);
    }

    public PasswordResetToken validatePasswordResetToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public void changeUserPassword(User user, String newPassword) {
        user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        userRepository.save(user);
    }
}*/

