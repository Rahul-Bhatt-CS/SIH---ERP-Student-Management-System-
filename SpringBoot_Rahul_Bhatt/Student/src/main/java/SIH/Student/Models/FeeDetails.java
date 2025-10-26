package SIH.Student.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "fee_details")
public class FeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique primary key for each fee record

    private String username;
    private String trxnNo;
    private Double amount;
    private String semester;
    private Date timeOfPayment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getTimeOfPayment() {
        return timeOfPayment;
    }

    public void setTimeOfPayment(Date timeOfPayment) {
        this.timeOfPayment = timeOfPayment;
    }
}
