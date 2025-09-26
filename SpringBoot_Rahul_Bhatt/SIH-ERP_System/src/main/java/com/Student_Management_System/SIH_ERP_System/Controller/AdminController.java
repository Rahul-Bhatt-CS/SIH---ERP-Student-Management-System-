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
    public List<CollegeDetails> getStudents(@RequestParam String status) {
        List<CollegeDetails> StudentsCollegeDetails = new ArrayList<>();

        if ("pending".equalsIgnoreCase(status)) {
            var student = authRepoStudentService.unregisteredStudents();
            student.forEach(k ->
                    StudentsCollegeDetails.add(collegeDetailsService.getSudentDetailsWithId(k))
            );
        } else if ("approved".equalsIgnoreCase(status)) {
            var student = authRepoStudentService.approvedStudents();
            student.forEach(k ->
                    StudentsCollegeDetails.add(collegeDetailsService.getSudentDetailsWithId(k))
            );

        }else if ("rejected".equalsIgnoreCase(status)){
            var student = authRepoStudentService.rejectedStudents();
            student.forEach(k ->
                    StudentsCollegeDetails.add(collegeDetailsService.getSudentDetailsWithId(k))
            );
        }

        return StudentsCollegeDetails;
    }
    @PutMapping("/api/admin/students")
    public String approve(@RequestParam String status,@RequestParam String studentId) {
        Integer a;
        if ("approve".equalsIgnoreCase(status)) a = 1;
        else if("reject".equalsIgnoreCase(status)) a = 2;
        else return "Bad Request";
        return authRepoStudentService.setStatus(studentId, a);
    }



    @PostMapping("/admin/login")
    public ResponseEntity<?> login(@RequestBody Student_Entity student){
        if(student == null){
            return ResponseEntity.badRequest().body("give me a student");
        }
        return ResponseEntity.ok(student);
    }

}
