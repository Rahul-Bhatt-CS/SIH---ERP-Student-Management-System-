package SIH.Student.Services;

import SIH.Student.Models.FeeDetails;
import SIH.Student.Repositories.FeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FeeService {
    @Autowired
    FeeRepo repo;

    public ResponseEntity<?> saveDetails(FeeDetails details){
        FeeDetails save = repo.save(details);
        if(save == null) return ResponseEntity.badRequest().body("could not save the details at the moment");
        return ResponseEntity.ok(save);
    }
}
