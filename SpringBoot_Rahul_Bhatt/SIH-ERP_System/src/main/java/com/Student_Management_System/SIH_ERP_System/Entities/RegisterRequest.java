package com.Student_Management_System.SIH_ERP_System.Entities;

public class RegisterRequest {
    private Student_Entity student;
    private Student_CollegeDetails studentCollegeDetails;

    public Student_Entity getStudent() {
        return student;
    }

    public void setStudent(Student_Entity student) {
        this.student = student;
    }

    public Student_CollegeDetails getStudentCollegeDetails() {
        return studentCollegeDetails;
    }

    public void setStudentCollegeDetails(Student_CollegeDetails studentCollegeDetails) {
        this.studentCollegeDetails = studentCollegeDetails;
    }
}
