package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "course_details")
public class CourseDetails {

    @EmbeddedId
    private CourseDetailsId id;

    @ManyToOne
    @MapsId("sId")
    @JoinColumn(name = "sid")
    private Student_Entity student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "courseid")
    private CourseTable course;

    private String semester;
    private Float marks;

    public CourseDetailsId getId() {
        return id;
    }

    public void setId(CourseDetailsId id) {
        this.id = id;
    }

    public CourseTable getCourse() {
        return course;
    }

    public void setCourse(CourseTable course) {
        this.course = course;
    }

    public Student_Entity getStudent() {
        return student;
    }

    public void setStudent(Student_Entity student) {
        this.student = student;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Float getMarks() {
        return marks;
    }

    public void setMarks(Float marks) {
        this.marks = marks;
    }
}

