package SIH.Student.Repositories;

import SIH.Student.Models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, String> {
    Courses findByCourseid(String id);

    @Query("SELECT c FROM Courses c")
    List<Courses> findAllCourses();
}