package SIH.Student.Services;

import SIH.Student.Models.CollegeDetails;
import SIH.Student.Models.FacultyDetails;
import SIH.Student.Repositories.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    @Autowired
    FacultyRepo repo;

    public ResponseEntity<?> setStatus(String username, Integer a){
        FacultyDetails details = repo.findByUsername(username);
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
