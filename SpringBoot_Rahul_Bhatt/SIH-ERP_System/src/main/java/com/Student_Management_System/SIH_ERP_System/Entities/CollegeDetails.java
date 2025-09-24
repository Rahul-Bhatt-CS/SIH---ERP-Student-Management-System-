package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "college_details")
public class CollegeDetails {
    @Id
    private String studentId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "studentid")
    private Student_Entity student;

    @ManyToOne
    @JoinColumn(name = "facultyid")
    private FacultyDetails faculty;

    private String name;
    private String branch;
    private String college;
    private Integer batch;
    private Long contact;
    private String email;
}
