package com.example.javaee.consumer.entity;

import java.io.Serializable;

public class MsgBean implements Serializable {
 
    private static final long serialVersionUID = 1L;

    public MsgBean(String uuid,String data,int customerID){
        this.uuid = uuid;
        this.data =data;
        this.customerid = customerID;
    }
    public MsgBean() {
	}
	/** uuid */
    private String uuid;

    //当发送的是申请成为一个课的学生，data存放这个课对应的 ID,若是申请vip，则置为null 
    private String data;

    //确定是哪个用户的操作
    private int customerid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    @Override
    public String toString() {
        return "MsgBean [customerid=" + customerid + ", data=" + data + ", uuid=" + uuid + "]";
    }
}