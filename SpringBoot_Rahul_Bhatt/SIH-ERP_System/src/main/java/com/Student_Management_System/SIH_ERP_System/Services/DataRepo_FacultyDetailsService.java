package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.FacultyDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.DataRepo_FacultyDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DataRepo_FacultyDetailsService {
    @Autowired
    DataRepo_FacultyDetails repo_facultyDetails;

    public FacultyDetails fetchFaculty(String fId){
        return repo_facultyDetails.findByFId(fId);
    }

    public ResponseEntity<?> savefaculty(FacultyDetails faculty){
        return ResponseEntity.ok(repo_facultyDetails.save(faculty));
    }

    public String setStatus(String facultyId, int value){
        FacultyDetails faculty = repo_facultyDetails.findByFId(facultyId);
        faculty.setRegistered(value);
        repo_facultyDetails.save(faculty);
        if(value == 1){
            return "Approved";
        }
        return "Rejected";
    }

}
