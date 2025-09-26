package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "faculty_details")
public class FacultyDetails {
    @Id
    private String fId;

    private String name;
    private String department;
    private String post;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CollegeDetails> students;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseTable> courses;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdvisorTable> advisors;

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<CollegeDetails> getStudents() {
        return students;
    }

    public void setStudents(List<CollegeDetails> students) {
        this.students = students;
    }

    public List<CourseTable> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseTable> courses) {
        this.courses = courses;
    }

    public List<AdvisorTable> getAdvisors() {
        return advisors;
    }

    public void setAdvisors(List<AdvisorTable> advisors) {
        this.advisors = advisors;
    }
}
