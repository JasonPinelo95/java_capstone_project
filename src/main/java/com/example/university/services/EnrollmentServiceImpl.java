package com.example.university.services;

import com.example.university.model.Enrollment;
import com.example.university.model.Student;
import com.example.university.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment findById(long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> findByStudentId(Student studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }
    @Override
    public void deleteById(long id) {
        enrollmentRepository.deleteById(id);
    }

}

