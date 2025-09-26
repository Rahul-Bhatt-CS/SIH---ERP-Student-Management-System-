package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Services.AuthRepo_StudentService;
import com.Student_Management_System.SIH_ERP_System.Services.DataRepo_CollegeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    DataRepo_CollegeDetailsService collegeDetailsService;
    @Autowired
    AuthRepo_StudentService authRepoStudentService;

    @GetMapping("/api/admin/students")
    public ResponseEntity<?> getDisabled(@RequestParam String status){
        if(status.equalsIgnoreCase("unregistered")){
            var student = authRepoStudentService.unregisteredStudents();
            List<CollegeDetails> urStudentsCollegeDetails = new ArrayList<>();
            student.forEach(k->
            {
                urStudentsCollegeDetails.add(collegeDetailsService.getSudentDetailsWithId(k));
            });
            return ResponseEntity.ok(urStudentsCollegeDetails);
        }
        return ResponseEntity.badRequest().body("use status unregistered to get students");

    }

    @PutMapping("/api/admin/approve")
    public ResponseEntity<?> approve(@RequestBody Student_Entity studentid, @RequestParam String status){
        if(status.equalsIgnoreCase("accept")) {
            return authRepoStudentService.approve(studentid, 1);
        }else if(status.equalsIgnoreCase("reject")){
            return authRepoStudentService.approve(studentid, 2);
        }
        return ResponseEntity.badRequest().body("not valid url");
    }
}
