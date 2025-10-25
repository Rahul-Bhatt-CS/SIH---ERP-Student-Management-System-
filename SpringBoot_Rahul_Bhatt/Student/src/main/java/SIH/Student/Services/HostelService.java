package SIH.Student.Services;

import SIH.Student.Models.HostelDetails;
import SIH.Student.Repositories.HostelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HostelService {
    @Autowired
    HostelRepo repo;

    public ResponseEntity<?> saveHostle(HostelDetails details){
        HostelDetails save = repo.save(details);
        if(save == null) return ResponseEntity.badRequest().body("could not save the details at the moment");
        return ResponseEntity.ok(save);
    }
}
