package com.example.university.services;

import com.example.university.model.Enrollment;
import com.example.university.model.Student;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> findAll();
    List<Enrollment> findByStudentId(Student studentId);
    Enrollment save(Enrollment enrollment);
    //void deleteById(Long id);
}
