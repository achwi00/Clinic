package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountCreatedController
{
    @RequestMapping("accountCreated")
    public String returnPage()
    {
        return "acc_crated.html";
    }

}
