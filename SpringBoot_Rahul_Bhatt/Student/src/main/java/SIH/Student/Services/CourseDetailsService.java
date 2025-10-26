package SIH.Student.Services;

import SIH.Student.Models.CourseDetails;
import SIH.Student.Repositories.CourseDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseDetailsService {
    @Autowired
    CourseDetailsRepo repo;

    public CourseDetails findRegistered(String id){
        return repo.findByUsername(id);
    }

    public ResponseEntity<?> registerStudent(CourseDetails details){
        CourseDetails save = repo.save(details);
        if(save == null) return ResponseEntity.badRequest().body("Could not register at the moment");
        return ResponseEntity.ok(save);
    }
}
