package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "auth_table_students")
public class Student_Entity {
    @Id
    private String sId;

    private String password;
    private Integer registered;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MiscDetails miscDetails;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private HostelDetails hostelDetails;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CollegeDetails collegeDetails;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdvisorTable> advisors;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseDetails> courses;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FeeDetails feeDetails;

    public FeeDetails getFeeDetails() {
        return feeDetails;
    }

    public void setFeeDetails(FeeDetails feeDetails) {
        this.feeDetails = feeDetails;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRegistered() {
        return registered;
    }

    public void setRegistered(Integer registered) {
        this.registered = registered;
    }

    public MiscDetails getMiscDetails() {
        return miscDetails;
    }

    public void setMiscDetails(MiscDetails miscDetails) {
        this.miscDetails = miscDetails;
    }

    public List<AdvisorTable> getAdvisors() {
        return advisors;
    }

    public void setAdvisors(List<AdvisorTable> advisors) {
        this.advisors = advisors;
    }

    public HostelDetails getHostelDetails() {
        return hostelDetails;
    }

    public void setHostelDetails(HostelDetails hostelDetails) {
        this.hostelDetails = hostelDetails;
    }

    public CollegeDetails getCollegeDetails() {
        return collegeDetails;
    }

    public void setCollegeDetails(CollegeDetails collegeDetails) {
        this.collegeDetails = collegeDetails;
    }

    public List<CourseDetails> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDetails> courses) {
        this.courses = courses;
    }
}
