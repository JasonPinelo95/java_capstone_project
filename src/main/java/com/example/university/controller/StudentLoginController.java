package com.example.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentLoginController {
    @GetMapping("/students/login")
    public String getStudentLogin(){
        return "students-login";
    }
}
