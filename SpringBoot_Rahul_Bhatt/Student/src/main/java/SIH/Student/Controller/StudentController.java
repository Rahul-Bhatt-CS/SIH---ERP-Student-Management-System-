package SIH.Student.Controller;

import SIH.Student.Models.CollegeDetails;
import SIH.Student.Models.HostelDetails;
import SIH.Student.Security.JwtUtil;
import SIH.Student.Services.CollegeService;
import SIH.Student.Services.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    CollegeService collegeService;
    @Autowired
    HostelService hostelService;

    @PostMapping("/college")
    public ResponseEntity<?> saveCollegeDetails(@RequestBody CollegeDetails collegeDetails,
                                                @RequestHeader("Authorization") String token){
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        collegeDetails.setUsername(username);
        collegeDetails.setApproved(0);
        return collegeService.saveDetails(collegeDetails);
    }

    @PostMapping("/hostel")
    public ResponseEntity<?> saveHostelDetails(@RequestBody HostelDetails hostelDetails,
                                               @RequestHeader("Authorization") String token){
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        hostelDetails.setUsername(username);
        return hostelService.saveHostle(hostelDetails);
    }


    @GetMapping("/hello")
    public String getUser(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        return "Hello " + username;
    }
}