package com.example.university.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EnrollmentPK implements Serializable {
    @Column(name = "student_id")
    private long studentId;

    @Column(name = "course_id")
    private long courseId;

    public EnrollmentPK(Long courseId, Long studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }
    //default constructor
    public EnrollmentPK() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "EnrollmentPK{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
