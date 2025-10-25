package SIH.Student.Services;

import SIH.Student.Models.CollegeDetails;
import SIH.Student.Repositories.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollegeService {
    @Autowired
    CollegeRepo repo;

    public ResponseEntity<?> saveDetails(CollegeDetails collegeDetails){
        CollegeDetails save = repo.save(collegeDetails);
        if(save != null) return ResponseEntity.ok(save);
        return ResponseEntity.badRequest().body("Could not save the Details at the moment");
    }

    public Optional<CollegeDetails> findPending(){
        return repo.findPending();
    }

    public Optional<CollegeDetails> findApproved(){
        return repo.findApproved();
    }

    public Optional<CollegeDetails> findRejected(){
        return repo.findRejected();
    }

    public ResponseEntity<?> setStatus(String username, Integer a){
        CollegeDetails details = repo.findByUsername(username);
        if(a == 1){
            details.setApproved(1);
            repo.save(details);
            return ResponseEntity.ok("Approved");
        }else if(a == 2){
            details.setApproved(2);
            repo.save(details);
            return ResponseEntity.ok("Rejected");
        }
        return ResponseEntity.badRequest().body("Could not Approve or Reject the Student");
    }
}
