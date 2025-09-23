package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "authTable_Students")
public class Student_Entity {
    @Id
    private String studentid;
    private String password;
    private boolean enabled;
    private String role;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
