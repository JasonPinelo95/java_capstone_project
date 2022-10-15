package com.example.university.controller;

import com.example.university.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorController {
    private final ProfessorsService professorsService;

    @Autowired
    public ProfessorController(ProfessorsService professorsService) {
        this.professorsService = professorsService;
    }

    @GetMapping("/professors")
    public String getProfessors(Model model){
        model.addAttribute("professors", professorsService.findAll());
        return "professors";
    }
}
