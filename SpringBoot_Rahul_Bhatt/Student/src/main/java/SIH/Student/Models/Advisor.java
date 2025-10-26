package SIH.Student.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "advisor")
public class Advisor {
    @Id
    private String student_id;
    private String faculty_id;

    public Advisor(){
    }

    public Advisor(String student_id, String faculty_id) {
        this.student_id = student_id;
        this.faculty_id = faculty_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }
}
