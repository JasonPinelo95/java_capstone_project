package com.example.university.services.implementation;

import com.example.university.model.Students;
import com.example.university.repository.StudentsRepository;
import com.example.university.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Students> findAll() {
        return studentsRepository.findAll();
    }

    @Override
    public Students findById(Long id) {
        return studentsRepository.findById(id).get();
    }

    @Override
    public Students save(Students students) {
        return studentsRepository.save(students);
    }

    @Override
    public void deleteById(Long id) {
        studentsRepository.deleteById(id);
    }

}

