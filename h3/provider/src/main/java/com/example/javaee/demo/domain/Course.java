package com.example.javaee.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = Course.COURSE)
public class Course implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String COURSE = "class";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer class_id;

    private int price;

    @NotEmpty(message = "User Name is required.")
    private String coursename;

    private int coach_id ;

    private String coachname;

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public String getCoachname() {
        return coachname;
    }

    public void setCoachname(String coachname) {
        this.coachname = coachname;
    }

    @Override
    public String toString() {
        return "Course [class_id=" + class_id + ", coach_id=" + coach_id + ", coachname=" + coachname + ", coursename="
                + coursename + ", price=" + price + "]";
    }


    
}
