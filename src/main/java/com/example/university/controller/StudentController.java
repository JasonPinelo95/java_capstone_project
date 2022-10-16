package com.example.university.controller;

import com.example.university.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students", studentService.findAll());
        return "students";
    }
    @GetMapping("students/dashboard")
    public String getStudentDashboard(){
        return "students-dashboard";
    }
}

