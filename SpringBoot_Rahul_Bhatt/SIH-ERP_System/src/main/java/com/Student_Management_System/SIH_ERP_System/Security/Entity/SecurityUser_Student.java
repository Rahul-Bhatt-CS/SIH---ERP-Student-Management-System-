package com.Student_Management_System.SIH_ERP_System.Security.Entity;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class SecurityUser_Student implements UserDetails {

    private final Student_Entity user;

    public SecurityUser_Student(Student_Entity user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("STUDENT"));
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getStudentid();
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
