package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo_Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthRepo_StudentService {
    @Autowired
    AuthRepo_Student repo;

    public String approve(String studentid, int value){
        repo.update(studentid, value);
        if(value == 1){
            return "Approved";
        }
        return "Rejected";
    }

    public ResponseEntity<?> register(Student_Entity student){
        if(repo.findByStudentid(student.getStudentid()) == null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            student.setPassword(encoder.encode(student.getPassword()));
            student.setEnabled(0);
            System.out.println(student);
            return ResponseEntity.ok(repo.save(student));
        }
        return ResponseEntity.badRequest().body("Student Already Registered");
    }

    public Student_Entity findByStudentid(String studentid){
        return repo.findByStudentid(studentid);
    }
}
