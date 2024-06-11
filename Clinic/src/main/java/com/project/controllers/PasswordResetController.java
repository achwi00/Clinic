package com.project.controllers;


import com.project.clinic.PasswordResetToken;
import com.project.service.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequestMapping("/reset")
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;

    @GetMapping("/form")
    public String showForm() {
        return "reset";
    }
    @PostMapping("/reset")
    public void addToken(String email) {
        passwordResetService.initiatePasswordReset(email);
    }

    @GetMapping("/code")
    public Optional<PasswordResetToken> getCode(String email) {
        return passwordResetService.getTokenByEmail(email);
    }

    /*@GetMapping("/form")
    public void getForm(String email, String imie, String phone, String text){
        passwordResetService.sendEmail(email, imie, phone, text);
    }*/
}
/*mport org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RestController
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/resetPassword")
    public ModelAndView resetPassword(@RequestParam("email") String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return new ModelAndView("error", "message", "No user found with that email address.");
        }
        String token = UUID.randomUUID().toString();
        passwordResetService.createPasswordResetTokenForUser(user, token);
        // Send email to user with token (Implement this according to your email service)
        return new ModelAndView("message", "message", "Password reset link sent to your email.");
    }

    @GetMapping("/changePassword")
    public ModelAndView showChangePasswordPage(@RequestParam("token") String token) {
        PasswordResetToken resetToken = passwordResetService.validatePasswordResetToken(token);
        if (resetToken == null) {
            return new ModelAndView("error", "message", "Invalid or expired password reset token.");
        }
        return new ModelAndView("updatePassword", "token", token);
    }

    @PostMapping("/savePassword")
    public ModelAndView savePassword(@RequestParam("token") String token, @RequestParam("password") String password) {
        PasswordResetToken resetToken = passwordResetService.validatePasswordResetToken(token);
        if (resetToken == null) {
            return new ModelAndView("error", "message", "Invalid or expired password reset token.");
        }
        User user = resetToken.getUser();
        passwordResetService.changeUserPassword(user, password);
        return new ModelAndView("message", "message", "Password successfully updated.");
    }
}*/
