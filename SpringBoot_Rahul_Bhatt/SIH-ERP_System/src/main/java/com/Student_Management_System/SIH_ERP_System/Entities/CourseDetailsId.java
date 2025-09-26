package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseDetailsId implements Serializable {

    private String sId;
    private String courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseDetailsId)) return false;
        CourseDetailsId that = (CourseDetailsId) o;
        return Objects.equals(sId, that.sId) &&
                Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, courseId);
    }
}
