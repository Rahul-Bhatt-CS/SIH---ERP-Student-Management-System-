package SIH.Student.Repositories;

import SIH.Student.Models.FeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeeRepo extends JpaRepository<FeeDetails, Long> {
    Optional<FeeDetails> findByUsername(String username);
}
