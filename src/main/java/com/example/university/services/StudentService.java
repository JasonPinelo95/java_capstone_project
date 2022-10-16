package com.example.university.services;

import com.example.university.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Long id);
    Student save(Student student);
    void deleteById(Long id);
}

