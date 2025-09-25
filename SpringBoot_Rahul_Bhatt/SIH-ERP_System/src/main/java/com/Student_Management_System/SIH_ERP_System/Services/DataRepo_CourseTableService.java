package com.Student_Management_System.SIH_ERP_System.Services;

import com.Student_Management_System.SIH_ERP_System.Repositories.DataRepo_CourseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataRepo_CourseTableService {
    @Autowired
    DataRepo_CourseTable repo_courseTable;
}
