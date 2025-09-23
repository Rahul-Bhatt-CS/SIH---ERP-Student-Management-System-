package com.Student_Management_System.SIH_ERP_System.Security;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUser implements UserDetailsService {

    @Autowired
    AuthRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student_Entity student = repo.findByStudentid(username);
        if(student == null){
            throw new UsernameNotFoundException("Student does not Exist");
        }
        return new PrincipalUser(student);
    }
}
