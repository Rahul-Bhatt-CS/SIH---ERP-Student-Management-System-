package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hostel_details")
public class HostelDetails {
    @Id
    private String studentId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "studentid")
    private Student_Entity student;

    private String nameOfHostel;
    private String room;
}
