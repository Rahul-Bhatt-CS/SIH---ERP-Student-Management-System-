package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AdvisorId implements Serializable {

    private String fId;
    private String sId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdvisorId)) return false;
        AdvisorId that = (AdvisorId) o;
        return Objects.equals(fId, that.fId) &&
                Objects.equals(sId, that.sId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fId, sId);
    }
}

