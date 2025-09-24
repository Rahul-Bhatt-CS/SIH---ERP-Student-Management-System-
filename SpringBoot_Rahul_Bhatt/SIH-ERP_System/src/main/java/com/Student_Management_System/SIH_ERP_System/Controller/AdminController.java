package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Services.AuthRepo_StudentService;
import com.Student_Management_System.SIH_ERP_System.Services.UnregisteredStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    UnregisteredStudents unregisteredStudents;
    @Autowired
    AuthRepo_StudentService authRepoStudentServiceService;

    @GetMapping("/unregisteredStudents")
    public List<CollegeDetails> getDisabled(){
        return unregisteredStudents.fetchStudents();
    }

    @PutMapping("/approveStudent/{value}")
    public String approve(@RequestBody String studentid
                            ,@PathVariable int value){
        return authRepoStudentServiceService.approve(studentid, value);
    }
}
