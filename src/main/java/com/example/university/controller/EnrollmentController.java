package com.example.university.controller;

import com.example.university.services.EnrollmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnrollmentController {

    private final EnrollmentsService enrollmentsService;

    @Autowired
    public EnrollmentController(EnrollmentsService enrollmentsService) {
        this.enrollmentsService = enrollmentsService;
    }

    @GetMapping("/enrollments")
    public String getEnrollments(Model model){
        model.addAttribute("enrollments", enrollmentsService.findAll());
        return "enrollments";
    }
}
