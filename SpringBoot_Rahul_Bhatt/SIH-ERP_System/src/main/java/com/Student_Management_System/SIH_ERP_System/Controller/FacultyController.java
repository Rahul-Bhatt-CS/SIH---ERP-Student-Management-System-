package com.Student_Management_System.SIH_ERP_System.Controller;

import com.Student_Management_System.SIH_ERP_System.Entities.FacultyDetails;
import com.Student_Management_System.SIH_ERP_System.Services.DataRepo_FacultyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FacultyController {
    @Autowired
    DataRepo_FacultyDetailsService facultyDetailsService;


//    register a Faculty
    @PostMapping("/faculty/register")
    public ResponseEntity<?> registerfaculty(@RequestBody FacultyDetails faculty){
        if(facultyDetailsService.fetchFaculty(faculty.getfId()) == null){
            return facultyDetailsService.savefaculty(faculty);
        }
        return ResponseEntity.badRequest().body("Enter a valid faculty entity");
    }


    // Approve Registration

    // Reject Registration
    //
}
