package com.example.university.services;

import com.example.university.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(Long id);
    Course save(Course course);
    void deleteById(Long id);
}
