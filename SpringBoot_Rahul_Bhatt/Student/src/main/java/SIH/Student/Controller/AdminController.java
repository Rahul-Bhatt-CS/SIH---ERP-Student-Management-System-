package SIH.Student.Controller;

import SIH.Student.Models.CollegeDetails;
import SIH.Student.Services.CollegeService;
import SIH.Student.Services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CollegeService collegeService;
    @Autowired
    FacultyService facultyService;

    @GetMapping("/students")
    public Optional<CollegeDetails> getStudents(@RequestParam String status) {
        Optional<CollegeDetails> StudentsCollegeDetails;
        if ("pending".equalsIgnoreCase(status)) {
            StudentsCollegeDetails = collegeService.findPending();
        } else if ("approved".equalsIgnoreCase(status)) {
            StudentsCollegeDetails = collegeService.findApproved();
        } else{
            StudentsCollegeDetails = collegeService.findRejected();
        }
        return StudentsCollegeDetails;
    }

    @PutMapping("/students")
    public ResponseEntity<?> approveStudent(@RequestParam String status,
                                            @RequestParam String username){
        Integer a;
        if ("approve".equalsIgnoreCase(status)) a = 1;
        else if("reject".equalsIgnoreCase(status)) a = 2;
        else return ResponseEntity.badRequest().body("Wrong Status Param");
        return collegeService.setStatus(username, a);
    }

    @PutMapping("/faculty")
    public ResponseEntity<?> approveFaculty(@RequestParam String status,
                                            @RequestParam String username){
        Integer a;
        if ("approve".equalsIgnoreCase(status)) a = 1;
        else if("reject".equalsIgnoreCase(status)) a = 2;
        else return ResponseEntity.badRequest().body("Wrong Status Param");
        return facultyService.setStatus(username, a);
    }
}