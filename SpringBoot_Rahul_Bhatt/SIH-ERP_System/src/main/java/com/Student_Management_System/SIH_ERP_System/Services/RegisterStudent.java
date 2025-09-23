package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterStudent {
    @Autowired
    AuthRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);


    public ResponseEntity<?> registerStudent(Student_Entity student){
        if(repo.findByStudentid(student.getStudentid()) == null){
            student.setPassword(encoder.encode(student.getPassword()));
            student.setEnabled(0);
            return ResponseEntity.ok(repo.save(student));
        }
        return ResponseEntity.badRequest().body("User already exists");
    }
}
