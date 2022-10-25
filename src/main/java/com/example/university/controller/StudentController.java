package com.example.university.controller;

import com.example.university.model.Enrollment;
import com.example.university.model.Student;
import com.example.university.services.CourseService;
import com.example.university.services.EnrollmentService;
import com.example.university.services.StudentService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
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
    public String addEnrollmentForm(Enrollment enrollment, Model model){
        model.addAttribute("courses", courseService.findAll());
        return "addenrollment";
    }

    @PostMapping("/students/addenrollment")
    public String addEnrollment(@Valid Enrollment enrollment, BindingResult result, Principal principal, Model model){
        if(result.hasErrors()){
            logger.info("Error adding enrollment");
            return "addenrollment";
        }
        List<Enrollment> currentEnrollments = enrollmentService.findByStudentId(studentService.findByEmail(principal.getName()));
        for(Enrollment e : currentEnrollments){
            if(e.getCourseId().equals(enrollment.getCourseId())){
                model.addAttribute("message", "You are already enrolled in this course");
                logger.debug("Error adding enrollment");
                return "redirect:/students/dashboard";
            }
        }
        Student student = studentService.findByEmail(principal.getName());
        enrollment.setStudentId(student);
        enrollmentService.save(enrollment);
        logger.info("Enrollment added");
        return "redirect:/students/dashboard";
    }

    // redirect /students to /students/dashboard
    @GetMapping(value = "/students")
    public String getStudentDashboardRedirect(){
        return "redirect:/students/dashboard";
    }

    @PostMapping("/students/unenroll/{id}")
    public String deleteEnrollment(@PathVariable("id") Long id, Model model){
        Enrollment enrollment = enrollmentService.findById(id);
        if (enrollment != null){
            enrollmentService.deleteById(id);
            logger.info("Deleted enrollment with id: " + id);
            return "redirect:/students/dashboard";
        }
        return "error/404";
    }
}

