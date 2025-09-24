package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course_table")
public class CourseTable {
    @Id
    private String courseId;

    @ManyToOne
    @JoinColumn(name = "facultyid")
    private FacultyDetails faculty;

    private int credits;
    private String courseName;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseDetails> students;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public FacultyDetails getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDetails faculty) {
        this.faculty = faculty;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<CourseDetails> getStudents() {
        return students;
    }

    public void setStudents(List<CourseDetails> students) {
        this.students = students;
    }
}
