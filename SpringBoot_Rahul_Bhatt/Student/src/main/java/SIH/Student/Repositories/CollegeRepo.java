package SIH.Student.Repositories;

import SIH.Student.Models.CollegeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollegeRepo extends JpaRepository<CollegeDetails, String> {
    CollegeDetails findByUsername(String username);

    @Query("SELECT c FROM CollegeDetails c WHERE c.approved = 0")
    Optional<CollegeDetails> findPending();
    @Query("SELECT c FROM CollegeDetails c WHERE c.approved = 1")
    Optional<CollegeDetails> findApproved();
    @Query("SELECT c FROM CollegeDetails c WHERE c.approved = 2")
    Optional<CollegeDetails> findRejected();
}
