package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Services.UnregisteredStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    UnregisteredStudents unregisteredStudents;

    @GetMapping("/approveStudents")
    public List<String> getDisabled(){
        return unregisteredStudents.fetchStudents();
    }
}
