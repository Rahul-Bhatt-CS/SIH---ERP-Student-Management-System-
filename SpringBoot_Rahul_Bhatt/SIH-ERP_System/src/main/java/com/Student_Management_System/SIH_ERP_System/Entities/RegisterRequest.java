package com.Student_Management_System.SIH_ERP_System.Entities;

public class RegisterRequest {
    private Student_Entity student;
    private CollegeDetails studentCollegeDetails;

    public Student_Entity getStudent() {
        return student;
    }

    public void setStudent(Student_Entity student) {
        this.student = student;
    }

    public CollegeDetails getStudentCollegeDetails() {
        return studentCollegeDetails;
    }

    public void setStudentCollegeDetails(CollegeDetails studentCollegeDetails) {
        this.studentCollegeDetails = studentCollegeDetails;
    }
}
