package com.Student_Management_System.SIH_ERP_System.Security;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class PrincipalUser implements UserDetails {

    private final Student_Entity user;

    public PrincipalUser(Student_Entity user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRole()));
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
    public boolean isEnabled() {
        return this.user.isEnabled();
    }
}
