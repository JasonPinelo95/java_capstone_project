package com.example.university.services;
import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void testFindById() {
        Student student = new Student();
        student.setStudentId(1L);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("John_Doe@students.com");

        studentService.save(student);

        when(studentRepository.findById(student.getStudentId())).thenReturn(Optional.of(student));

        Student foundStudent = studentService.findById(student.getStudentId());

        assertEquals(foundStudent.getStudentId(), student.getStudentId());
    }
}