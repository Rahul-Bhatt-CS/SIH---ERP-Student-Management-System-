package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "advisor_table")
public class AdvisorTable {
    @EmbeddedId
    private AdvisorId id;

    @ManyToOne
    @MapsId("facultyId")
    @JoinColumn(name = "facultyid")
    private FacultyDetails faculty;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentid")
    private Student_Entity student;
}
