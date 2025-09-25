package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Repositories.DataRepo_AdvisorAdvisee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataRepo_AdvisorAdviseeService {
    @Autowired
    DataRepo_AdvisorAdvisee repo_advisorAdvisee;
}
