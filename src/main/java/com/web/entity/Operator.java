package com.web.entity;

/**
 * Created by sukey on 2016/7/26.
 */

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OPERATOR")
public class Operator {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "mobile_phone")
    private String mobile_phone;
    @Column(name = "email")
    private String name;
    @Column(name = "name")
    private String email;
    @Column(name = "create_time")
    private Date create_time;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getMobile_phone() {
        return this.mobile_phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getCreate_time() {
        return this.create_time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
