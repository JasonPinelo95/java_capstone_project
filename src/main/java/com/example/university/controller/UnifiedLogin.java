package com.example.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UnifiedLogin {
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request){
        if(request.isUserInRole("STUDENT")){
            return "redirect:/students";
        }
        else if(request.isUserInRole("PROFESSOR")){
            return "redirect:/professors";
        }
        else{
            return "redirect:/";
        }
    }
}
