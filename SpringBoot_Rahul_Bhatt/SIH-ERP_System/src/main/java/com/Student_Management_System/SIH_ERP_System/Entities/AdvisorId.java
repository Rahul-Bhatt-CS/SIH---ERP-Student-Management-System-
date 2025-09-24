package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AdvisorId implements Serializable {

    private String facultyId;
    private String studentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdvisorId)) return false;
        AdvisorId that = (AdvisorId) o;
        return Objects.equals(facultyId, that.facultyId) &&
                Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, studentId);
    }
}

