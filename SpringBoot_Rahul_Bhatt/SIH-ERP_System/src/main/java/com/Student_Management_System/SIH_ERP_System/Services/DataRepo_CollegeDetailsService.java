package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import com.Student_Management_System.SIH_ERP_System.Repositories.DataRepo_CollegeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataRepo_CollegeDetailsService {
    @Autowired
    DataRepo_CollegeDetails repoCollegeDetails;

    public void register(CollegeDetails details, Student_Entity student){
        details.setStudent(student);
        repoCollegeDetails.save(details);
    }

    public List<CollegeDetails> unregiestered(List<String> studentids){
        List<CollegeDetails> collegeDetails = new ArrayList<CollegeDetails>();
        for (int i = 0; i < studentids.size(); i++){
            CollegeDetails details = repoCollegeDetails.findByStudentid(studentids.get(i));
            details.setStudent(null);
            collegeDetails.add(details);
        }
        return collegeDetails;
    }
}
