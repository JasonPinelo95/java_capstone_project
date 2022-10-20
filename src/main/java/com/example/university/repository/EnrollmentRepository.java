package com.example.university.repository;

import com.example.university.model.Enrollment;
import com.example.university.model.EnrollmentPK;
import com.example.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Student studentId);
}