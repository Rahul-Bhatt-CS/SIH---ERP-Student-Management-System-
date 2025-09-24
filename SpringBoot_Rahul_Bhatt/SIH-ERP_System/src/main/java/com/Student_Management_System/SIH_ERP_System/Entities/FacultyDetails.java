package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "faculty_details")
public class FacultyDetails {
    @Id
    private String facultyId;

    private String name;
    private String department;
    private String post;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CollegeDetails> students;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseTable> courses;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdvisorTable> advisors;
}
