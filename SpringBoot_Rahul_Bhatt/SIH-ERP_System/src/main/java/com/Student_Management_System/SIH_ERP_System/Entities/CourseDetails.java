package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "course_details")
public class CourseDetails {

    @EmbeddedId
    private CourseDetailsId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentid")
    private Student_Entity student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "courseid")
    private CourseTable course;

    private String semester;
    private Float marks;
}

