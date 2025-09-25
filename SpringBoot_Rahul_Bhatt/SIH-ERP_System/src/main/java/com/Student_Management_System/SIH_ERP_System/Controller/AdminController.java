package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Services.AuthRepo_StudentService;
import com.Student_Management_System.SIH_ERP_System.Services.DataRepo_CollegeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    DataRepo_CollegeDetailsService collegeDetailsService;
    @Autowired
    AuthRepo_StudentService authRepoStudentServiceService;

    @GetMapping("/unregisteredStudents")
    public List<CollegeDetails> getDisabled(){
        return collegeDetailsService.unregiestered(authRepoStudentServiceService.unregisteredStudents());
    }

    @PutMapping("/approveStudent/{value}")
    public String approve(@RequestBody Student_Entity studentid
                            ,@PathVariable int value){
        return authRepoStudentServiceService.approve(studentid, value);
    }
}
