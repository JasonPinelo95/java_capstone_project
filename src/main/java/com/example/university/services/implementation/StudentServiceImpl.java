package com.example.university.services.implementation;

import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;
import com.example.university.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}

