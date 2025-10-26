package SIH.Student.Repositories;

import SIH.Student.Models.MiscDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiscDetailsRepo extends JpaRepository<MiscDetails, String> {
    MiscDetails findByUsername(String username);
}
