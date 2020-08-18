package com.alan.testproject.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

@Entity
public class DataBean{

    String time;
    String data;
    @Generated(hash = 681842785)
    public DataBean(String time, String data) {
        this.time = time;
        this.data = data;
    }
    @Generated(hash = 908697775)
    public DataBean() {
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
