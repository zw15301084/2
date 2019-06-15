package com.example.demo.domain.primary;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Coach.COACH)
public class Coach  implements Serializable {

    /**
     *
     */
    static final String COACH = "coach";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coach_id;

    @NotEmpty(message = "User Name is required.")
    private String username;

    @Size(min = 6, max = 20, message = "Password must more than 6  chars and less 20 chars")
    private String password;

    @Size(min = 11, max = 11, message = "Mobile no. must be 11 digits.")
    @Column(name = "mobile_no")
    private String mobileNum;

    @NotEmpty(message="Specialties is required")
    private String specialties;

    @NotEmpty(message="motto is required")
    private String motto;

    @NotEmpty(message = "Address is required.")
    private String address;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(Integer coach_id) {
        this.coach_id = coach_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Coach(){super();}

    public String getSpecialties() {
        return specialties;
    }
    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }
    public String getMotto() {
        return motto;
    }
    public Coach(@NotEmpty(message = "User Name is required.") String username,
                 @Size(min = 6, max = 20, message = "Password must more than 6  chars and less 20 chars") String password,
                 @Size(min = 11, max = 11, message = "Mobile no. must be 11 digits.") String mobileNum,
                 @NotEmpty(message = "Specialties is required") String specialties,
                 @NotEmpty(message = "motto is required") String motto,
                 @NotEmpty(message = "Address is required.")
                         String address,
                 List<Course> courses) {
        this.username = username;
        this.password = password;
        this.mobileNum = mobileNum;
        this.specialties = specialties;
        this.motto = motto;
        this.address = address;
        this.courses = courses;
    }
    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coach_id=" + coach_id +
                ", username='" + username + '\'' +
               // ", password='" + password + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", specialties='" + specialties + '\'' +
                ", motto='" + motto + '\'' +
                ", address='" + address + '\'' +
                ", courses=" + courses +
                '}';
    }
}