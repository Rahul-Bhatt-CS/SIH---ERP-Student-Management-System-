package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.DataRepo_CollegeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataRepo_CollegeDetailsService {
    @Autowired
    DataRepo_CollegeDetails repoCollegeDetails;

    public void register(CollegeDetails details, Student_Entity student){
        details.setStudent(student);
        repoCollegeDetails.save(details);
    }
}
