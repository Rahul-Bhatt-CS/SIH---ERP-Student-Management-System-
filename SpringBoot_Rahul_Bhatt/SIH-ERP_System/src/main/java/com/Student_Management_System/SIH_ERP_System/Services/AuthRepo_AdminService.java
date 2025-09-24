package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.Admin_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthRepo_AdminService {
    @Autowired
    AuthRepo_Admin repoAdmin;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public ResponseEntity<?> registernewAdmin(Admin_Entity admin){
        if(repoAdmin.findByUsername(admin.getUsername()) == null){
            admin.setPassword(encoder.encode(admin.getPassword()));
            System.out.println("Saved: " + admin);
            return ResponseEntity.ok(repoAdmin.save(admin));
        }
        return ResponseEntity.badRequest().body("Admin Already Exists");
    }
}
