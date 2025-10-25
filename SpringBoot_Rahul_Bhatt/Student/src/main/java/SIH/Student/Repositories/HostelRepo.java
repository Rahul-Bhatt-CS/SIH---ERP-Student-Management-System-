package SIH.Student.Repositories;

import SIH.Student.Models.HostelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HostelRepo extends JpaRepository<HostelDetails, Long> {
    Optional<HostelDetails> findByUsername(String username);
}
