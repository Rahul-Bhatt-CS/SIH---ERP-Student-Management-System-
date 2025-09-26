package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fee_details")
public class FeeDetails {

    @Id
    @Column(name = "s_id")
    private String sId;   // Primary key and also foreign key

    private String trxnNo;
    private Double amount;
    private String semester;

    @Column(name = "time_of_payment")
    private LocalDateTime timeOfPayment;

    // Relationship with Student
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId  // Uses sId as both PK and FK
    @JoinColumn(name = "s_id", referencedColumnName = "sId")
    private Student_Entity student;

    // Getters and Setters
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getTrxnNo() {
        return trxnNo;
    }

    public void setTrxnNo(String trxnNo) {
        this.trxnNo = trxnNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public LocalDateTime getTimeOfPayment() {
        return timeOfPayment;
    }

    public void setTimeOfPayment(LocalDateTime timeOfPayment) {
        this.timeOfPayment = timeOfPayment;
    }

    public Student_Entity getStudent() {
        return student;
    }

    public void setStudent(Student_Entity student) {
        this.student = student;
    }
}
