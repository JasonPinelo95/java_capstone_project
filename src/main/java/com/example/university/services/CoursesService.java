package com.example.university.services;

import com.example.university.model.Courses;

import java.util.List;

public interface CoursesService {
    List<Courses> findAll();
    Courses findById(Long id);
    Courses save(Courses courses);
    void deleteById(Long id);
}
