package SIH.Student.Services;

import SIH.Student.Models.Advisor;
import SIH.Student.Models.CollegeDetails;
import SIH.Student.Repositories.AdvisorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvisorService {
    @Autowired
    AdvisorRepo repo;

    public List<CollegeDetails> getAdvisee(String faculty){
        return repo.findAllByFacultyName(faculty);
    }

    public ResponseEntity<?> saveAdvisor(Advisor advisor){
        Advisor save = repo.save(advisor);
        if(save == null) return ResponseEntity.badRequest().body("Could not save the Details at the moment");
        return ResponseEntity.ok(save);
    }
}
