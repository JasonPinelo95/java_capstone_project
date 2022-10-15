package com.example.university.services;

import com.example.university.model.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> findAll();
    Professor findById(Long id);
    Professor save(Professor professor);

    void deleteById(Long id);
}
