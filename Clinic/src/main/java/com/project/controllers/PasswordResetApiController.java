package com.project.controllers;

import com.project.clinic.PasswordResetToken;
import com.project.repository.PasswordResetTokenRepository;
import com.project.service.PasswordResetService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/password")
public class PasswordResetApiController {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;
    @Autowired
    private PasswordResetService passwordResetService;
    @Autowired
    HttpServletRequest request;
    @PostMapping("/reset")
    public void addToken(String email) {
        passwordResetService.initiatePasswordReset(email);
    }

    @GetMapping("/code")
    public Optional<PasswordResetToken> getCode(String email) {
        return passwordResetService.getTokenByEmail(email);
    }
}
