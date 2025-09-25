package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.HostelDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Services.AuthRepo_StudentService;
import com.Student_Management_System.SIH_ERP_System.Services.DataRepo_HostelDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StudentController {
    @Autowired
    AuthRepo_StudentService studentService;
    @Autowired
    DataRepo_HostelDetailsService hostelDetailsService;

    @PostMapping("/student/hostel")
    public ResponseEntity<?> registerHostel(@RequestBody HostelDetails details){
        Student_Entity student = studentService.fetchStudent(details.getStudentid());
        details.setStudent(student);
        return hostelDetailsService.registerHostel(details);
    }
}
