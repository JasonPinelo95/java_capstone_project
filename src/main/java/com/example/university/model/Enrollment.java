package com.example.university.model;

import javax.persistence.*;

@Entity
//@Data
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @Column(name = "enrollment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long enrollmentId;


    @Column(name = "grade")
    private String grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courseId;


    public long getId() {
        return enrollmentId;
    }

    public void setId(long id) {
        this.enrollmentId = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

}
