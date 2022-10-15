package com.example.university.repository;

import com.example.university.model.Enrollment;
import com.example.university.model.EnrollmentsPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentsRepository extends JpaRepository<Enrollment, EnrollmentsPK> {
}