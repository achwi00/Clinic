package com.project.clinic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResetToken;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private String emailToReset;

    // Getters and Setters


    public Long getIdResetToken() {
        return idResetToken;
    }

    public void setIdResetToken(Long idResetToken) {
        this.idResetToken = idResetToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmailToReset() {
        return emailToReset;
    }

    public void setEmailToReset(String emailToReset) {
        this.emailToReset = emailToReset;
    }
}
