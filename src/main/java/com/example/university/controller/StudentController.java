package com.example.university.controller;

import com.example.university.model.Student;
import com.example.university.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students/dashboard")
    public String getStudentDashboard(Principal principal, Model model){
        Student student = studentService.findByEmail(principal.getName());
        model.addAttribute("student", student);
        return "students-dashboard";
    }
}

