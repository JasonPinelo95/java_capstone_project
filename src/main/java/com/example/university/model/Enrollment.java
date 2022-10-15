package com.example.university.model;

import javax.persistence.*;

@Entity
//@Data
@Table(name = "enrollments")
public class Enrollment {
    @EmbeddedId
    private EnrollmentPK id;

    @Column(name = "grade")
    private String grade;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course courseId;


    public EnrollmentPK getId() {
        return id;
    }

    public void setId(EnrollmentPK id) {
        this.id = id;
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
