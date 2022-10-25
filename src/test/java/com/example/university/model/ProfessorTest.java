package com.example.university.model;

import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

public class ProfessorTest {
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";
    public static final String EMAIL = "John_Doe@professors.com";
    public static final String PASSWORD = "password";
    public static final Date HIRE_DATE = new Date(2019, 1, 1);

    @Test
    public void testProfessor() {
        Professor professor = new Professor();
        professor.setFirstName(FIRST_NAME);
        professor.setLastName(LAST_NAME);
        professor.setEmail(EMAIL);
        professor.setPassword(PASSWORD);
        professor.setHireDate(HIRE_DATE);

        assertEquals(FIRST_NAME, professor.getFirstName());
        assertEquals(LAST_NAME, professor.getLastName());
        assertEquals(EMAIL, professor.getEmail());
        assertEquals(PASSWORD, professor.getPassword());
        assertEquals(HIRE_DATE, professor.getHireDate());
    }

}