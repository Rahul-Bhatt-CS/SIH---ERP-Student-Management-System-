package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "college_details")
public class CollegeDetails {

    @Id
    private String studentid;

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

    public FacultyDetails getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDetails faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
