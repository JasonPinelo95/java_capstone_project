package com.example.university.controller;

import com.example.university.model.Professor;
import com.example.university.services.implementation.ProfessorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProfessorServiceImpl professorService;

    @Autowired
    public HomeController(ProfessorServiceImpl professorService) {
        this.professorService = professorService;
    }
    @GetMapping(value = {"/", "/index", "/home"})
    public String getHome(){
        return "home";
    }

    @GetMapping(value = "/faculty")
    public String getFaculty(Model model){
        model.addAttribute("professors", professorService.findAll());
        return "faculty";
    }
}
