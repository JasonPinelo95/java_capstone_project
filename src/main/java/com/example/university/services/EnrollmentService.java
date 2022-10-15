package com.example.university.services;

import com.example.university.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> findAll();
    Enrollment save(Enrollment enrollment);
    //void deleteById(Long id);
}
