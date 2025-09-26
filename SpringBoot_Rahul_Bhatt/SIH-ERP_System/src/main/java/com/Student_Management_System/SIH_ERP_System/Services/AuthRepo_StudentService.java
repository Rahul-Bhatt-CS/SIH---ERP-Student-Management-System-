package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo_Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthRepo_StudentService {
    @Autowired
    AuthRepo_Student repo;

    public ResponseEntity<?> register(Student_Entity student){
        if(repo.findBySId(student.getsId()) == null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            student.setPassword(encoder.encode(student.getPassword()));
            student.setRegistered(0);
            System.out.println(student);
            return ResponseEntity.ok(repo.save(student));
        }
        return ResponseEntity.badRequest().body("Student Already Registered");
    }

    public Student_Entity fetchStudent(String studentid){
        return repo.findBySId(studentid);
    }


    public String approve(Student_Entity studentid, int value){
        Student_Entity student = repo.findBySId(studentid.getsId());
        student.setRegistered(value);
        repo.save(student);
        if(value == 1){
            return "Approved";
        }
        return "Rejected";
    }

    public List<String> unregisteredStudents(){
        return repo.findDisabledStudents();
    }

}
