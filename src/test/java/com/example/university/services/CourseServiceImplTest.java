package com.example.university.services;

import com.example.university.model.Course;
import com.example.university.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CourseServiceImplTest {
    @Mock
    CourseRepository courseRepository;

    @Test
    void findById() {
        when(courseRepository.findById(1L)).thenReturn(java.util.Optional.of(new Course()));
        assertEquals(courseRepository.findById(1L), java.util.Optional.of(new Course()));
    }
}