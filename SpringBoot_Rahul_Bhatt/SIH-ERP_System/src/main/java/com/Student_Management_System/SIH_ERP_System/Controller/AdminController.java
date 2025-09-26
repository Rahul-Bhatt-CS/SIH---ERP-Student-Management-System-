package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
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

    @GetMapping("/api/admin/students")
    public List<CollegeDetails> getStudents(@RequestParam String status) {
        List<CollegeDetails> StudentsCollegeDetails = new ArrayList<>();

        if ("unregistered".equalsIgnoreCase(status)) {
            var student = authRepoStudentService.unregisteredStudents();
            student.forEach(k ->
                    StudentsCollegeDetails.add(collegeDetailsService.getSudentDetailsWithId(k))
            );
        } else if ("approved".equalsIgnoreCase(status)) {
            //get approved students
        }else if ("rejected".equalsIgnoreCase(status)){
            //get rejected students
        }

        return StudentsCollegeDetails;
    }
    @PutMapping("/api/admin/student")
    public String approve(@RequestParam String status,@RequestParam String studentId) {
        Integer a;
        if ("setStatus".equalsIgnoreCase(status)) a = 1;
        else a = 2;
        return authRepoStudentService.setStatus(studentId, a);
    }
//    @PutMapping("/api/admin/student/setStatus")
//    public String setStatus(@RequestBody Student_Entity studentid){
//        return authRepoStudentService.setStatus(studentid,1);
//    }
//    @PutMapping("/api/admin/student/reject")
//    public String reject(@RequestBody Student_Entity studentid
//            ,@PathVariable int value){
//        return authRepoStudentService.setStatus(studentid,1);
//    }
}
