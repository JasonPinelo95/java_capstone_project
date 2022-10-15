package com.example.university.services;

import com.example.university.model.Professors;

import java.util.List;

public interface ProfessorsService {
    List<Professors> findAll();
    Professors findById(Long id);
    Professors save(Professors professors);

    void deleteById(Long id);
}
