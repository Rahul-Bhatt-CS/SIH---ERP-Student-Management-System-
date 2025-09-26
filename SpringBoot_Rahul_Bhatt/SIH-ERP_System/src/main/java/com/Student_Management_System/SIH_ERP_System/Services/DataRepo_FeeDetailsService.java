package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Entities.FeeDetails;
import com.Student_Management_System.SIH_ERP_System.Repositories.DataRepo_FeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataRepo_FeeDetailsService {
    @Autowired
    DataRepo_FeeDetails repoFeeDetails;

    public List<FeeDetails> fetchFee(String id){return repoFeeDetails.findBySId(id);}


    public ResponseEntity<?> semesterFee(FeeDetails details){
        FeeDetails details1 = repoFeeDetails.save(details);
        return ResponseEntity.ok(details1);
    }
}
