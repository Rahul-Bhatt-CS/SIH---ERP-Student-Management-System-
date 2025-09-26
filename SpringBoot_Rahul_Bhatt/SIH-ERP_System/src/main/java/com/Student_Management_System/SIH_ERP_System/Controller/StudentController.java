package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.HostelDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Services.AuthRepo_StudentService;
import com.Student_Management_System.SIH_ERP_System.Services.DataRepo_HostelDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    AuthRepo_StudentService studentService;
    @Autowired
    DataRepo_HostelDetailsService hostelDetailsService;

    @PostMapping("api/student/hostel")
    public ResponseEntity<?> registerHostel(@RequestBody HostelDetails details){
        Student_Entity student = studentService.fetchStudent(details.getStudentid());
        System.out.println(details.getStudentid());
        details.setStudent(student);
        return hostelDetailsService.registerHostel(details);
    }

    //Course Registration-> POST api/student/course
    //                     -> One Course at a Time
    //See Report Card semester registration status etc....
    // Get api/student/details-> use query parameters field,semester,id and if else to distinguish what details to send back
    //                           e.g. field = fee send fee details back

}
