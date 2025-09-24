package com.Student_Management_System.SIH_ERP_System.Repositories;

import com.Student_Management_System.SIH_ERP_System.Entities.CollegeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo_CollegeDetails extends JpaRepository<CollegeDetails, String> {
    CollegeDetails findByStudentid(String username);
}
