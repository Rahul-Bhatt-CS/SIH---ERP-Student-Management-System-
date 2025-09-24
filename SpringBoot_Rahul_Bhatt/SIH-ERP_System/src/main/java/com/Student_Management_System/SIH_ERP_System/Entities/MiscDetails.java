package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "misc_details")
public class MiscDetails {
    @Id
    private String studentId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "studentid")
    private Student_Entity student;

    private String localAddress;
    private String district;
    private String state;
    private int pincode;
}
