package com.project.controllers;

public class PasswordResetController {
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
