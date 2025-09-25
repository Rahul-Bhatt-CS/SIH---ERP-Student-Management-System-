package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Repositories.DataRepo_HostelDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataRepo_HostelDetailsService {
    @Autowired
    DataRepo_HostelDetails repo_hostelDetails;
}
