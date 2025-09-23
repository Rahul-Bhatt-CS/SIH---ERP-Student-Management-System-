package com.Student_Management_System.SIH_ERP_System.Security;

import com.Student_Management_System.SIH_ERP_System.Entities.User_Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class PrincipalUser implements UserDetails {

    private final User_Entity user;

    public PrincipalUser(User_Entity user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }
}
