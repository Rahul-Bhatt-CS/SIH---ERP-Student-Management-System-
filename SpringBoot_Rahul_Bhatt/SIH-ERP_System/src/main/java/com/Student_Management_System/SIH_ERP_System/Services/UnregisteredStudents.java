package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_CollegeDetails;
import com.Student_Management_System.SIH_ERP_System.Repositories.AuthRepo;
import com.Student_Management_System.SIH_ERP_System.Repositories.StudentRepo_CollegeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnregisteredStudents {
    @Autowired
    AuthRepo repo;
    @Autowired
    StudentRepo_CollegeDetails studentRepoCollegeDetails;

    public List<Student_CollegeDetails> fetchStudents(){
        List<String> students = repo.findDisabledStudents();
        List<Student_CollegeDetails> studentDetails = new ArrayList<Student_CollegeDetails>();
        for(String str : students){
            studentDetails.add(studentRepoCollegeDetails.findByStudentid(str));
        }
        return studentDetails;
    }
}
