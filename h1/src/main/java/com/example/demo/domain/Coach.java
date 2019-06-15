package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @NotEmpty(message = "Address is required.")
    private String address;

    /*@ManyToMany(mappedBy = "coachs",fetch = FetchType.EAGER)
    private Set<Customer> customers;*/

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * @return the coach_id
     */
    public Integer getCoach_id() {
        return coach_id;
    }

    /**
     * @param coach_id the coach_id to set
     */
    public void setCoach_id(Integer coach_id) {
        this.coach_id = coach_id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mobileNum
     */
    public String getMobileNum() {
        return mobileNum;
    }

    /**
     * @param mobileNum the mobileNum to set
     */
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /*public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }*/

    @Override
    public String toString() {
        return "Coach{" +
                "coach_id=" + coach_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", address='" + address + '\'' +
               // ", students=" + customers.size() +
                '}';
    }
    public Coach(){super();}

    public Coach(@NotEmpty(message = "User Name is required.") String username,
                 @Size(min = 6, max = 20, message = "Password must more than 6  chars and less 20 chars") String password,
                 @Size(min = 11, max = 11, message = "Mobile no. must be 11 digits.") String mobileNum,
                 @NotEmpty(message = "Address is required.") String address) {
        this.username = username;
        this.password = password;
        this.mobileNum = mobileNum;
        this.address = address;
        //this.customers = new HashSet<>();
        this.courses = new ArrayList<>();
    }
}