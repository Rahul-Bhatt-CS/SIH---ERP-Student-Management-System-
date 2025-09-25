package com.Student_Management_System.SIH_ERP_System.Security.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.Admin_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo_Admin;
import com.Student_Management_System.SIH_ERP_System.Security.Entity.SecurityUser_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUser_AdminDetailsService implements UserDetailsService{
    @Autowired
    AuthRepo_Admin repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin_Entity admin = repo.findByUsername(username);
        if(admin == null){
            throw new UsernameNotFoundException("Admin Not Found");
        }
        return new SecurityUser_Admin(admin);
    }
}
