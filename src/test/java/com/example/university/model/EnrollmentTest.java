package com.example.university.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnrollmentTest {
    public static final String GRADE = "A";
    public static final long STUDENT_ID = 1;
    public static final long COURSE_ID = 1;

    @Test
    public void testEnrollment() {
        Student student = new Student();
        student.setStudentId(STUDENT_ID);
        Course course = new Course();
        course.setCourseId(COURSE_ID);
        Enrollment enrollment = new Enrollment();
        enrollment.setGrade(GRADE);
        enrollment.setStudentId(student);
        enrollment.setCourseId(course);

        assertEquals(GRADE, enrollment.getGrade());
        assertEquals(STUDENT_ID, enrollment.getStudentId().getStudentId());
        assertEquals(COURSE_ID, enrollment.getCourseId().getCourseId());
    }
}