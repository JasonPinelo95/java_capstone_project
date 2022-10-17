package com.example.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorLoginController {
    @GetMapping("/professors/login")
    public String getProfessorLogin(){
        return "professors-login";
    }
}
