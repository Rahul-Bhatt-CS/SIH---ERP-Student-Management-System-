package com.Student_Management_System.SIH_ERP_System.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/test")
    public String hello(){
        return "Hello!";
    }
}
