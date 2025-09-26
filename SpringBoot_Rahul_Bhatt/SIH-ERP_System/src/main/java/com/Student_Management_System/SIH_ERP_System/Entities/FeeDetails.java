package com.Student_Management_System.SIH_ERP_System.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fee_details")
public class FeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique primary key for each fee record

    private String trxnNo;
    private Double amount;
    private String semester;

    @Column(name = "time_of_payment")
    private LocalDateTime timeOfPayment;

    // Many fee records can belong to one student
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id", referencedColumnName = "sId")
    private Student_Entity student;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
