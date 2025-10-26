package SIH.Student.Controller;

import SIH.Student.Models.CollegeDetails;
import SIH.Student.Models.FeeDetails;
import SIH.Student.Models.HostelDetails;
import SIH.Student.Models.MiscDetails;
import SIH.Student.Security.JwtUtil;
import SIH.Student.Services.CollegeService;
import SIH.Student.Services.FeeService;
import SIH.Student.Services.HostelService;
import SIH.Student.Services.MiscDetailsService;
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
    @Autowired
    FeeService feeService;
    @Autowired
    MiscDetailsService miscDetailsService;

    @PostMapping("/college")
    public ResponseEntity<?> saveCollegeDetails(@RequestBody CollegeDetails collegeDetails,
                                                @RequestHeader("Authorization") String token){
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        collegeDetails.setUsername(username);
        collegeDetails.setApproved(0);
        return collegeService.saveDetails(collegeDetails);
    }

    @PostMapping("/fees")
    public ResponseEntity<?> saveFeeDetails(@RequestBody FeeDetails details,
                                            @RequestHeader("Authorization") String token){
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        FeeDetails oldDetails = feeService.getfees(username, details.getSemester());
        if(oldDetails != null) return ResponseEntity.badRequest().body("FeeDetails already submitted Remove previous Details to add new one.");
        details.setUsername(username);
        return feeService.saveDetails(details);
    }

    @PostMapping("/hostel")
    public ResponseEntity<?> saveHostelDetails(@RequestBody HostelDetails hostelDetails,
                                               @RequestHeader("Authorization") String token){
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        hostelDetails.setUsername(username);
        return hostelService.saveHostle(hostelDetails);
    }

    @PostMapping("/misc")
    public ResponseEntity<?> saveMiscDetails(@RequestBody MiscDetails details,
                                             @RequestHeader("Authorization") String token){
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        details.setUsername(username);
        return miscDetailsService.saveDetails(details);
    }

    @GetMapping("/hello")
    public String getUser(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.validateAndGetClaims(token.substring(7)).getSubject();
        return "Hello " + username;
    }
}