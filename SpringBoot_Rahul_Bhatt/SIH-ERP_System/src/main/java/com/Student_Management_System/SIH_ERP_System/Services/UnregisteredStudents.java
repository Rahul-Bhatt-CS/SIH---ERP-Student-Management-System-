package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo_Student;
import com.Student_Management_System.SIH_ERP_System.Repositories.DataRepo_CollegeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnregisteredStudents {
    @Autowired
    AuthRepo_Student repo;
    @Autowired
    DataRepo_CollegeDetails studentRepoCollegeDetails;

    public List<CollegeDetails> fetchStudents(){
        List<String> students = repo.findDisabledStudents();
        List<CollegeDetails> collegeDetails = new ArrayList<CollegeDetails>();
        for (int i = 0; i < students.size(); i++) {
            CollegeDetails details = studentRepoCollegeDetails.findByStudentid(students.get(i));
            details.setStudent(null);
            collegeDetails.add(details);
        }
        return collegeDetails;
    }
}
