package com.example.university.services;

import com.example.university.model.Enrollment;

import java.util.List;

public interface EnrollmentsService {
    List<Enrollment> findAll();
    Enrollment save(Enrollment enrollment);
    //void deleteById(Long id);
}
