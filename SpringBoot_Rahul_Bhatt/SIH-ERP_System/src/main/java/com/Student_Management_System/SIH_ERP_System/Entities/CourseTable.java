package com.Student_Management_System.SIH_ERP_System.Entities;

import com.Student_Management_System.SIH_ERP_System.Controller.CourseDetails;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course_table")
public class CourseTable {
    @Id
    private String courseId;

    @ManyToOne
    @JoinColumn(name = "facultyid")
    private FacultyDetails faculty;

    private int credits;
    private String courseName;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CourseDetails> students;
}
