package com.Student_Management_System.SIH_ERP_System.Repositories;

import com.Student_Management_System.SIH_ERP_System.Entities.Admin_Entity;
import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepo extends JpaRepository<Student_Entity, String> {
    Student_Entity findByStudentid(String ID);
    @Query("SELECT s.studentid FROM Student_Entity s WHERE s.enabled = 0")
    List<String> findDisabledStudents();
}
