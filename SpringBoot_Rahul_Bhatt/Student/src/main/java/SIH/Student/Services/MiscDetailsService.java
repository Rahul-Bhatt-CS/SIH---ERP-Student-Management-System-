package SIH.Student.Services;

import SIH.Student.Models.MiscDetails;
import SIH.Student.Repositories.MiscDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MiscDetailsService {
    @Autowired
    MiscDetailsRepo repo;

    public ResponseEntity<?> saveDetails(MiscDetails details){
        MiscDetails save = repo.save(details);
        if(save == null) return ResponseEntity.badRequest().body("Could not save Details at the Moment");
        return ResponseEntity.ok(save);
    }
}
