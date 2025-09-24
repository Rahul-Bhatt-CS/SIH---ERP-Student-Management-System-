package com.Student_Management_System.SIH_ERP_System.Repositories;

import com.Student_Management_System.SIH_ERP_System.Entities.Student_Entity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepo_Student extends JpaRepository<Student_Entity, String> {
    Student_Entity findByStudentid(String ID);
    @Query(value = "SELECT s.studentid FROM Student_Entity s WHERE s.enabled = 0")
    List<String> findDisabledStudents();

    @Modifying
    @Transactional
    @Query(value = "UPDATE auth_table_students SET enabled = :status WHERE studentid = :studentid", nativeQuery = true)
    int update(@Param("studentid")String studentid, @Param("status") int status);
}
