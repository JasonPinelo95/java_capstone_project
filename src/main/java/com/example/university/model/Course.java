package com.example.university.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
//@Data
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "credits")
    private int credits;

    @Column(name = "semester")
    private int semester;

    @ManyToOne
    @JoinColumn(name = "professor_id", insertable = false, updatable = false)
    private Professor professorId;

    @OneToMany(mappedBy = "courseId")
    private List<Enrollment> enrollments;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Professor getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Professor professorId) {
        this.professorId = professorId;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

}
