package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Services.AuthRepo_StudentService;
import com.Student_Management_System.SIH_ERP_System.Services.DataRepo_CollegeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    DataRepo_CollegeDetailsService collegeDetailsService;
    @Autowired
    AuthRepo_StudentService authRepoStudentService;

    @GetMapping("/api/admin/students?status=unregistered")
    public List<CollegeDetails> getDisabled(){
        var student = authRepoStudentService.unregisteredStudents();
        List<CollegeDetails> urStudentsCollegeDetails = new ArrayList<>();
        student.forEach(k->
        {
            urStudentsCollegeDetails.add(collegeDetailsService.getSudentDetailsWithId(k));
        });
        return urStudentsCollegeDetails;
    }

    @PutMapping("/api/admin/student/approve")
    public String approve(@RequestBody Student_Entity studentid){
        return authRepoStudentService.approve(studentid,1);
    }
    @PutMapping("/api/admin/student/reject")
    public String reject(@RequestBody Student_Entity studentid
            ,@PathVariable int value){
        return authRepoStudentService.approve(studentid,1);
    }
}
