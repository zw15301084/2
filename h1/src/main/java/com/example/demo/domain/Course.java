package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Course.COURSE)
public class Course {

    static final String COURSE = "course";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer course_id;

    @NotEmpty(message = "User Name is required.")
    private String coursename;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    /**
     * 1、关系维护端，负责多对多关系的绑定和解除
     * 2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(Customer)
     * 3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Coach)
     * 4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，即表名为Customer_Coach
     * 关联到主表的外键名：主表名+下划线+主表中的主键列名,即customer_id
     * 关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即acoazh_id
     * 主表就是关系维护端对应的表，从表就是关系被维护端对应的表
     */
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "course_customer",
            joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")})
    private List<Customer> customers;


    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Course(){};
    public Course(String coursename) {
        this.coursename = coursename;
        this.coach = new Coach();
        this.customers = new ArrayList<>();
    }
}
