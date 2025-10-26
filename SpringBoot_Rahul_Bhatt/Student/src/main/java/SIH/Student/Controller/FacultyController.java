package SIH.Student.Controller;

import SIH.Student.Models.Advisor;
import SIH.Student.Models.CollegeDetails;
import SIH.Student.Models.Courses;
import SIH.Student.Models.FacultyDetails;
import SIH.Student.Security.JwtUtil;
import SIH.Student.Services.AdvisorService;
import SIH.Student.Services.CollegeService;
import SIH.Student.Services.CoursesService;
import SIH.Student.Services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    FacultyService facultyService;
    @Autowired
    AdvisorService advisorService;
    @Autowired
    CollegeService collegeService;
    @Autowired
    CoursesService coursesService;

    @PostMapping("/details")
    public ResponseEntity<?> saveFaculty(@RequestBody FacultyDetails details,
                                         @RequestHeader("Authorization") String token){
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        details.setUsername(username);
        details.setApproved(0);
        return facultyService.saveDetails(details);
    }

    @PostMapping("/advisor")
    public ResponseEntity<?> saveAdvisor(@RequestBody List<String> students,
                                         @RequestHeader("Authorization") String token){
        List<String> noStudent = new ArrayList<>();
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        for(String student : students){
            CollegeDetails studentDetails = collegeService.getDetails(student);
            if(studentDetails == null){
                noStudent.add(student);
                continue;
            }
            studentDetails.setFacultyid(username);
            collegeService.saveDetails(studentDetails);

            Advisor studentAdvisor = new Advisor(student, username);
            advisorService.saveAdvisor(studentAdvisor);
        }
        if(noStudent.isEmpty()) return ResponseEntity.ok("Saved all Students");
        return ResponseEntity.badRequest().body("Students not found: " + noStudent);
    }

    @GetMapping("/advisee")
    public List<CollegeDetails> getAdvisee(@RequestHeader("Authorization") String token){
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        return advisorService.getAdvisee(username);
    }

    @PostMapping("/course")
    public ResponseEntity<?> addNewCourse(@RequestBody Courses courses){
        String facultyid = courses.getFaculty_id();
        FacultyDetails faculty = facultyService.findFaculty(facultyid);
        if(faculty == null){
            return ResponseEntity.badRequest().body("Faculty Not Found");
        }
        return coursesService.saveCourse(courses);
    }
}
