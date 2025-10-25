package SIH.Student.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "hostel_details")
public class HostelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // unique id per record
    private Long id;
    private String username;
    private String nameOfHostel;
    private String room;
    private String sem;
    private String year;

    public String getNameOfHostel() {
        return nameOfHostel;
    }

    public void setNameOfHostel(String nameOfHostel) {
        this.nameOfHostel = nameOfHostel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
