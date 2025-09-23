package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Services.RegisterStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublicController {
    @Autowired
    RegisterStudent registerStudent;

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody Student_Entity student){
        return registerStudent.registerStudent(student);
    }
}
