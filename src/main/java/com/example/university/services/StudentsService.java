package com.example.university.services;

import com.example.university.model.Students;

import java.util.List;

public interface StudentsService {
    List<Students> findAll();
    Students findById(Long id);
    Students save(Students students);

    void deleteById(Long id);
}

