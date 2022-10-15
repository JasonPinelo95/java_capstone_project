package com.example.university.controller;

import com.example.university.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {
    private final CoursesService coursesService;

    @Autowired
    public CourseController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping("/courses")
    public String getCourses(Model model){
        model.addAttribute("courses", coursesService.findAll());
        return "courses";
    }
}
