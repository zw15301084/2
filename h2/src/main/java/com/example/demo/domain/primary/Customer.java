package com.example.demo.domain.primary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = Customer.CUSTOMER)
public class Customer implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final String CUSTOMER = "customer";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "User Name is required.")
    private String username;

    @Size(min = 6, max = 20, message = "Password must more than 6  chars and less 20 chars")
    private String password;

    @Size(min = 11, max = 11, message = "Mobile no. must be 11 digits.")
    @Column(name = "mobile_no")
    private String mobileNum;

    @NotEmpty(message = "Address is required.")
    private String address;

    /*@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "costomer_coach",
            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "coach_id", referencedColumnName = "coach_id")})*/
   // private Set<Coach> coachs;

    @ManyToMany(mappedBy = "customers",fetch = FetchType.EAGER)
    private List<Course> courses;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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

    /*public Set<Coach> getCoachs() {
        return coachs;
    }

    public void setCoachs(Set<Coach> coachs) {
        coachs = coachs;
    }*/

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", address='" + address + '\'' +
               // ", Coachs=" + coachs.size() +
                '}';
    }

    public Customer(){super();}
    public Customer(@NotEmpty(message = "User Name is required.") String username,
                    @Size(min = 6, max = 20, message = "Password must more than 6  chars and less 20 chars") String password,
                    @Size(min = 11, max = 11, message = "Mobile no. must be 11 digits.") String mobileNum,
                    @NotEmpty(message = "Address is required.") String address) {
        this.username = username;
        this.password = password;
        this.mobileNum = mobileNum;
        this.address = address;
        //this.coachs = new HashSet<>();
        this.courses = new ArrayList<Course>();
    }
}