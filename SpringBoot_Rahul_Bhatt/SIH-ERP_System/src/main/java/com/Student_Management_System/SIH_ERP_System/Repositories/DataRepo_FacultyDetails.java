package com.Student_Management_System.SIH_ERP_System.Repositories;

import com.Student_Management_System.SIH_ERP_System.Entities.FacultyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepo_FacultyDetails extends JpaRepository<FacultyDetails, String> {
    FacultyDetails findByFId(String id);
}
