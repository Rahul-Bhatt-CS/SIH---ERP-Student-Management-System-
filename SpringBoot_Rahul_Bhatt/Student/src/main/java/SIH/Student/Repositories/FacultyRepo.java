package SIH.Student.Repositories;

import SIH.Student.Models.FacultyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepo extends JpaRepository<FacultyDetails, String> {
    FacultyDetails findByUsername(String username);
}
