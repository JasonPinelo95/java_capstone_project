package com.example.university.services.implementation;

import com.example.university.model.Enrollment;
import com.example.university.model.Student;
import com.example.university.repository.EnrollmentRepository;
import com.example.university.services.EnrollmentService;
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
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> findByStudentId(Student studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    //Fix this method
    //@Override
    //public void deleteById(Long id) {
    //    enrollmentsRepository.deleteById(id);
    //}

}

