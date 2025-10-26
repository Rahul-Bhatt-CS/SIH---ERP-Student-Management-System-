package SIH.Student.Repositories;

import SIH.Student.Models.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDetailsRepo extends JpaRepository<CourseDetails, Integer> {
    CourseDetails findByUsername(String id);
}
