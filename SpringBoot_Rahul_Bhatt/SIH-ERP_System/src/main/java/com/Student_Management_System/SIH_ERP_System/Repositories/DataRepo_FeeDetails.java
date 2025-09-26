package com.Student_Management_System.SIH_ERP_System.Repositories;

import com.Student_Management_System.SIH_ERP_System.Entities.FeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepo_FeeDetails extends JpaRepository<FeeDetails, String> {
    FeeDetails findBySId(String id);
}
