package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.FeeDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.HostelDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.DataRepo_FeeDetails;
import com.Student_Management_System.SIH_ERP_System.Services.AuthRepo_StudentService;
import com.Student_Management_System.SIH_ERP_System.Services.DataRepo_FeeDetailsService;
import com.Student_Management_System.SIH_ERP_System.Services.DataRepo_HostelDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    AuthRepo_StudentService studentService;
    @Autowired
    DataRepo_HostelDetailsService hostelDetailsService;
    @Autowired
    DataRepo_FeeDetailsService dataRepoFeeDetails;

    @PostMapping("/api/student/hostel/{sId}")
    public ResponseEntity<?> registerHostel(@RequestBody HostelDetails details, @PathVariable String sId){
        Student_Entity student = studentService.fetchStudent(sId);
        details.setStudent(student);
        return hostelDetailsService.registerHostel(details);
    }

    //Course Registration-> POST api/student/course
    //                     -> One Course at a Time
    //See Report Card semester registration status etc....
    // Get api/student/details-> use query parameters field,semester,id and if else to distinguish what details to send back
    //                           e.g. field = fee send fee details back

//    @GetMapping("api/student/details")
//    public ResponseEntity<?> getDetails(@RequestParam String infoType,
//                                        @RequestParam Integer semester,
//                                        @RequestParam String studentId){
//        Object details;
//        if("fee".equalsIgnoreCase(infoType)){
//
//        } else if ("registration".equalsIgnoreCase(infoType)) {
//            List<FeeDetails> details = dataRepoFeeDetails.getDetails(semester,studentId);
//        } else if ("reportCard".equalsIgnoreCase(infoType)) {
//
//        }else{
//
//        }
//        return ResponseEntity.of(details);
//    }

    @PostMapping("/student/login")
    public ResponseEntity<?> login(@RequestBody Student_Entity student){
        if(student == null){
            return ResponseEntity.badRequest().body("give me a student");
        }
        return ResponseEntity.ok(student);
    }

}
