package com.Student_Management_System.SIH_ERP_System.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//ANish teri maa ki chut
@RestController
public class StudentController {
    @GetMapping("/")
    public String hello(){
        return "Hello!";
    }
}
