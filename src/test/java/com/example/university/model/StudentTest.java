package com.example.university.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";
    public static final String EMAIL = "John_Doe@students.com";
    public static final String PASSWORD = "password";
    public static final int SEMESTER = 1;

    @Test
    public void testStudent() {
        Student student = new Student();
        student.setFirstName(FIRST_NAME);
        student.setLastName(LAST_NAME);
        student.setEmail(EMAIL);
        student.setPassword(PASSWORD);
        student.setSemester(SEMESTER);

        assertEquals(FIRST_NAME, student.getFirstName());
        assertEquals(LAST_NAME, student.getLastName());
        assertEquals(EMAIL, student.getEmail());
        assertEquals(PASSWORD, student.getPassword());
        assertEquals(SEMESTER, student.getSemester());
    }



}