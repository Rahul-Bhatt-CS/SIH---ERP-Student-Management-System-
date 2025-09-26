package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.Admin_Entity;
import com.Student_Management_System.SIH_ERP_System.Entities.RegisterRequest;
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
