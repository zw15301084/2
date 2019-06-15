package com.example.demo.domain.secondary;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseViewLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int viewlog_id;

    @CreatedBy
    @Column(name = "create_by")
    private String createBy;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    @LastModifiedBy
    @Column(name = "last_update_by")
    private String lastUpdateBy;

    @LastModifiedDate
    @Column(name = "last_update_time")
    private Date lastUpdateTime;


    public int getViewlog_id() {
        return viewlog_id;
    }

    public void setViewlog_id(int viewlog_id) {
        this.viewlog_id = viewlog_id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "BaseViewLog{" +
                "viewlog_id=" + viewlog_id +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
