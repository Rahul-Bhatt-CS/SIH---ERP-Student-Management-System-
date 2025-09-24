package com.Student_Management_System.SIH_ERP_System;

import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SihErpSystemApplication {
    public static void main(String[] args) {
		SpringApplication.run(SihErpSystemApplication.class, args);
	}

}
