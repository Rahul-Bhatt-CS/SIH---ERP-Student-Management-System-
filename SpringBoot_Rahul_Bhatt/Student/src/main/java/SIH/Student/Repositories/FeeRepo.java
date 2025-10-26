package SIH.Student.Repositories;

import SIH.Student.Models.FeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeeRepo extends JpaRepository<FeeDetails, Long> {
    Optional<FeeDetails> findByUsername(String username);
    @Query("SELECT f FROM FeeDetails f WHERE f.username = :name AND f.semester = :sem")
    FeeDetails findByUserSem(@Param("name") String username,@Param("sem") String sem);
}
