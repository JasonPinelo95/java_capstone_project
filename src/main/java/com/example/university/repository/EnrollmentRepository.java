package com.example.university.repository;

import com.example.university.model.Enrollment;
import com.example.university.model.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}