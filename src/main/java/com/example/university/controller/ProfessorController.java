package com.example.university.controller;

import com.example.university.model.Professor;
import com.example.university.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfessorController {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/professors/dashboard")
    public String getProfessorDashboard(Principal principal, Model model){
        Professor professor = professorService.findByEmail(principal.getName());
        model.addAttribute("professor", professor);
        return "professors-dashboard";
    }

}
