package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "misc_details")
public class MiscDetails {
    @Id
    private String studentid;

    @OneToOne
    @MapsId
    @JoinColumn(name = "studentid")
    private Student_Entity student;

    private String localAddress;
    private String district;
    private String state;
    private int pincode;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public Student_Entity getStudent() {
        return student;
    }

    public void setStudent(Student_Entity student) {
        this.student = student;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
