package com.Student_Management_System.SIH_ERP_System.Security.Entity;

import com.Student_Management_System.SIH_ERP_System.Entities.Admin_Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityUser_Admin implements UserDetails {

    private final Admin_Entity admin;

    public SecurityUser_Admin(Admin_Entity admin){
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public String getPassword() {
        return this.admin.getPassword();
    }

    @Override
    public String getUsername() {
        return this.admin.getUsername();
    }
}
