package SIH.Student.Repositories;

import SIH.Student.Models.Advisor;
import SIH.Student.Models.CollegeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvisorRepo extends JpaRepository<Advisor, String> {
    @Query("SELECT s FROM CollegeDetails s JOIN Advisor f ON s.username = f.student_id WHERE f.faculty_id = :name")
    List<CollegeDetails> findAllByFacultyName(@Param("name") String username);
}
