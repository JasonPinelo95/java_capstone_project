package com.example.university.controller;

import com.example.university.model.Enrollment;
import com.example.university.model.Student;
import com.example.university.services.CourseService;
import com.example.university.services.EnrollmentService;
import com.example.university.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
public class StudentController {
    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    private final CourseService courseService;

    @Autowired
    public StudentController(StudentService studentService, EnrollmentService enrollmentService, CourseService courseService) {
        this.studentService = studentService;
        this.enrollmentService = enrollmentService;
        this.courseService = courseService;
    }

    @GetMapping("/students/dashboard")
    public String getStudentDashboard(Principal principal, Model model){
        Student student = studentService.findByEmail(principal.getName());
        List<Enrollment> enrollments = enrollmentService.findByStudentId(student);
        model.addAttribute("student", student);
        model.addAttribute("enrollments", enrollments);
        return "students-dashboard";
    }

    @GetMapping("/students/addenrollment")
    public String addEnrollment(Model model){
        model.addAttribute("enrollment", new Enrollment());
        model.addAttribute("courses", courseService.findAll());
        return "addenrollment";
    }

    @PostMapping("/students/addenrollment")
    public String addEnrollment(@ModelAttribute("enrollment") Enrollment enrollment, BindingResult result, Principal principal, Model model){
        if(result.hasErrors()){
            return "addenrollment";
        }
        Student student = studentService.findByEmail(principal.getName());
        enrollment.setStudentId(student);
        enrollmentService.save(enrollment);
        return "redirect:/students/dashboard";
    }

    // redirect /students to /students/dashboard
    @GetMapping(value = "/students")
    public String getStudentDashboardRedirect(){
        return "redirect:/students/dashboard";
    }
}

