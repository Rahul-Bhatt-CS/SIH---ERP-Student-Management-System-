package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.Admin_Entity;
import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Services.AuthRepo_AdminService;
import com.Student_Management_System.SIH_ERP_System.Services.AuthRepo_StudentService;
import com.Student_Management_System.SIH_ERP_System.Services.DataRepo_CollegeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
public class PublicController {
    @Autowired
    AuthRepo_StudentService studentService;
    @Autowired
    DataRepo_CollegeDetailsService collegeDetails;
    @Autowired
    AuthRepo_AdminService adminService;

    @PostMapping("/api/register")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterRequest request){
        ResponseEntity<?> response = studentService.register(request.getStudent());
        collegeDetails.register(request.getStudentCollegeDetails(), studentService.fetchStudent(request.getStudent().getsId()));
        return response;
    }

    @PostMapping("/api/admin/register")
    public ResponseEntity<?> registerAdmin(@RequestBody Admin_Entity admin){
        return adminService.registernewAdmin(admin);
    }
}







class RegisterRequest{
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
