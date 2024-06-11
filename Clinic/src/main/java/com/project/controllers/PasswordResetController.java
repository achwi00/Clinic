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
public class PasswordResetController {

    @Autowired
    private PasswordResetApiController passwordResetApiController;

    @RequestMapping("password")
    public String showForm() {
        return "reset.html";
    }
    @RequestMapping("/token")
    public String showTokenForm() {
        return "token.html";
    }
    @RequestMapping("/changePassword")
    public String showChangePasswordForm() {
        return "changePassword.html";
    }
}

