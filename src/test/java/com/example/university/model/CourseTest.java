package com.example.university.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {
    public static final String COURSE_NAME = "Java";
    public static final String COURSE_DESCRIPTION = "Java Programming";
    public static final int CREDITS = 3;

    @Test
    public void testCourse() {
        Course course = new Course();
        course.setName(COURSE_NAME);
        course.setDescription(COURSE_DESCRIPTION);
        course.setCredits(CREDITS);

        assertEquals(COURSE_NAME, course.getName());
        assertEquals(COURSE_DESCRIPTION, course.getDescription());
        assertEquals(CREDITS, course.getCredits());
    }

}