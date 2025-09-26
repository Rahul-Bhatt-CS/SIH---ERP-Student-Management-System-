package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hostel_details")
public class HostelDetails {
    @Id
    private String sId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "sid")
    private Student_Entity student;

    private String nameOfHostel;
    private String room;
    private String sem;
    private String year;


    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public Student_Entity getStudent() {
        return student;
    }

    public void setStudent(Student_Entity student) {
        this.student = student;
    }

    public String getNameOfHostel() {
        return nameOfHostel;
    }

    public void setNameOfHostel(String nameOfHostel) {
        this.nameOfHostel = nameOfHostel;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
