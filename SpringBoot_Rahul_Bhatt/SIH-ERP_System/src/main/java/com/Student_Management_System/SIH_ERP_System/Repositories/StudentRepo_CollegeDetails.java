package com.Student_Management_System.SIH_ERP_System.Repositories;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_CollegeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo_CollegeDetails extends JpaRepository<Student_CollegeDetails, String> {
    Student_CollegeDetails findByStudentid(String username);
}
