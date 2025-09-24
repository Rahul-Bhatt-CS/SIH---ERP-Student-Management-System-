package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hostel_details")
public class HostelDetails {
    @Id
    private String studentid;

    @OneToOne
    @MapsId
    @JoinColumn(name = "studentid")
    private Student_Entity student;

    private String nameOfHostel;
    private String room;

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
}
