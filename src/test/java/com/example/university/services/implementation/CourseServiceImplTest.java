package com.example.university.services.implementation;

import com.example.university.model.Course;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CourseServiceImplTest {
    @Mock
    CourseServiceImpl courseService;
    @Test
    void findById() {
        when(courseService.findById(1L)).thenReturn(new Course());
        assertEquals(courseService.findById(1L), new Course());
    }
}