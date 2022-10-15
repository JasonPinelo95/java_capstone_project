package com.example.university.services.implementation;

import com.example.university.model.Courses;
import com.example.university.repository.CoursesRepository;
import com.example.university.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    private final CoursesRepository coursesRepository;

    @Autowired
    public CoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Courses> findAll() {
        return coursesRepository.findAll();
    }

    @Override
    public Courses findById(Long id) {
        return coursesRepository.findById(id).get();
    }

    @Override
    public Courses save(Courses courses) {
        return coursesRepository.save(courses);
    }

    @Override
    public void deleteById(Long id) {
        coursesRepository.deleteById(id);
    }

}

