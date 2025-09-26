package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hostel_details")
public class HostelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // unique id per record
    private Long id;

    private String nameOfHostel;
    private String room;
    private String sem;
    private String year;

    // Many hostel entries can belong to one student
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id", referencedColumnName = "sId")
    private Student_Entity student;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Student_Entity getStudent() {
        return student;
    }

    public void setStudent(Student_Entity student) {
        this.student = student;
    }
}
