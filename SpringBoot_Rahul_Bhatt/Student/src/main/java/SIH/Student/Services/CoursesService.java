package SIH.Student.Services;

import SIH.Student.Models.Courses;
import SIH.Student.Repositories.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    CoursesRepo repo;

    public Courses getCourse(String id){
        return repo.findByCourseid(id);
    }

    public List<Courses> getCourse(){
        return repo.findAllCourses();
    }

    public ResponseEntity<?> saveCourse(Courses courses){
        Courses save = repo.save(courses);
        if(save == null) return ResponseEntity.badRequest().body("Could not Save at the moment");
        return ResponseEntity.ok(save);
    }
}
