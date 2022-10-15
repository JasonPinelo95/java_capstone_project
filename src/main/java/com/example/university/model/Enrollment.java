package com.example.university.model;

import lombok.Data;

import javax.persistence.*;

@Entity
//@Data
@Table(name = "enrollments")
public class Enrollment {
    @EmbeddedId
    private EnrollmentsPK id;

    @Column(name = "grade")
    private String grade;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Students studentId;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Courses courseId;


    public EnrollmentsPK getId() {
        return id;
    }

    public void setId(EnrollmentsPK id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Students getStudentId() {
        return studentId;
    }

    public void setStudentId(Students studentId) {
        this.studentId = studentId;
    }

    public Courses getCourseId() {
        return courseId;
    }

    public void setCourseId(Courses courseId) {
        this.courseId = courseId;
    }

}
