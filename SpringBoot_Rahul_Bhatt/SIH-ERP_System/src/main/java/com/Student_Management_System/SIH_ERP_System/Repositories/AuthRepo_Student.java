package com.Student_Management_System.SIH_ERP_System.Repositories;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepo_Student extends JpaRepository<Student_Entity, String> {
    Student_Entity findBySId(String ID);

    @Query(value = "SELECT s.sId FROM Student_Entity s WHERE s.registered = 0")
    List<String> findDisabledStudents();
}
