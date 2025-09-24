package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo;
import com.Student_Management_System.SIH_ERP_System.Repositories.StudentRepo_CollegeDetails;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterStudent {
    @Autowired
    StudentRepo_CollegeDetails studentRepoCollegeDetails;
    @Autowired
    AuthRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Transactional
    public ResponseEntity<?> registerStudent(Student_Entity student, CollegeDetails studentCollegeDeatils){
        if(repo.findByStudentid(student.getStudentid()) == null){
            student.setPassword(encoder.encode(student.getPassword()));
            student.setEnabled(0);
            repo.save(student);
            studentCollegeDeatils.setStudent(repo.findByStudentid(student.getStudentid()));
            studentRepoCollegeDetails.save(studentCollegeDeatils);
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.badRequest().body("User Alreaady Exists");
    }
}
