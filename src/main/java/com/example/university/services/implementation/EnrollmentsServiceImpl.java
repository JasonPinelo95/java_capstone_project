package com.example.university.services.implementation;

import com.example.university.model.Enrollment;
import com.example.university.repository.EnrollmentsRepository;
import com.example.university.services.EnrollmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentsServiceImpl implements EnrollmentsService {
    private final EnrollmentsRepository enrollmentsRepository;

    @Autowired
    public EnrollmentsServiceImpl(EnrollmentsRepository enrollmentsRepository) {
        this.enrollmentsRepository = enrollmentsRepository;
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentsRepository.findAll();
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentsRepository.save(enrollment);
    }

    //Fix this method
    //@Override
    //public void deleteById(Long id) {
    //    enrollmentsRepository.deleteById(id);
    //}

}

