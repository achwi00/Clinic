package com.project.controllers;

import com.project.clinic.PasswordResetToken;
import com.project.repository.PasswordResetTokenRepository;
import com.project.service.PasswordResetService;
import com.project.service.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/password")
public class PasswordResetApiController {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;
    @Autowired
    private PasswordResetService passwordResetService;

    @Autowired
    private PatientService patientService;

    @Autowired
    HttpServletRequest request;
   /* @PostMapping("/reset")
    public void addToken(String email) {
        passwordResetService.initiatePasswordReset(email);
    }*/
    @PostMapping("/reset")
    public ResponseEntity<Void> addToken(String email) {
        passwordResetService.initiatePasswordReset(email);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/token"))
                .build();
    }

    /*@PostMapping("/verify")
    public ResponseEntity<String> verifyToken(String token) {
        Optional<PasswordResetToken> resetToken = Optional.ofNullable(passwordResetTokenRepository.findByToken(token));
        if (resetToken.isPresent()) {
            return ResponseEntity.ok("Token verified successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid token");
        }
    }*/
    @PostMapping("/verify")
    public ResponseEntity<Void> verifyToken(String token) {
        Optional<PasswordResetToken> resetToken = Optional.ofNullable(passwordResetTokenRepository.findByToken(token));
        if (resetToken.isPresent()) {
            request.getSession().setAttribute("email", resetToken.get().getEmailToReset());
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("/changePassword"))
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

   /* @PostMapping("/update")
    public ResponseEntity<String> updatePassword(String password) {
        String email = (String) request.getSession().getAttribute("email");
        if (email != null) {
            patientService.updatePassword(email, password);
            request.getSession().removeAttribute("email"); // Remove the email from session after use
            return ResponseEntity.ok("Password changed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Session expired or invalid");
        }
    }*/
   @PostMapping("/update")
   public ResponseEntity<Void> updatePassword(String password) {
       String email = (String) request.getSession().getAttribute("email");
       if (email != null) {
           patientService.updatePassword(email, password);
           request.getSession().removeAttribute("email"); // Remove the email from session after use
           return ResponseEntity.status(HttpStatus.FOUND)
                   .location(URI.create("/index.html")) // Redirect to login page
                   .build();
       } else {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .build();
       }
   }

}
