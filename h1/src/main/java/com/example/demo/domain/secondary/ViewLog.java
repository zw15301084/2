package com.example.demo.domain.secondary;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="viewlog")
public class ViewLog{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int viewlog_id;

    private int customer_id;

    private int course_id;

    @CreatedDate
    @Column(name = "createTime")
    private Date createTime;

    public int getViewlog_id() {
        return viewlog_id;
    }

    public void setViewlog_id(int viewlog_id) {
        this.viewlog_id = viewlog_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public ViewLog(int customer_id, int course_id) {
        this.customer_id = customer_id;
        this.course_id = course_id;
    }

    public ViewLog(){};

    @Override
    public String toString() {
        return "ViewLog{" +
                "viewlog_id=" + viewlog_id +
                ", customer_id=" + customer_id +
                ", course_id=" + course_id +
                ", createTime=" + createTime +
                '}';
    }
}
