package com.Student_Management_System.SIH_ERP_System.Repositories;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<Student_Entity, String> {
    Student_Entity findByStudentid(String ID);
}
