package com.web.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gaoyang on 16/7/3.
 */
@Entity
@Table(name = "PRODUCT_REMINDER")
public class ProductReminder {
    @Id
        @GeneratedValue( generator = "uuid" )
        @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                @Parameter(
                    name = "uuid_gen_strategy_class",
                    value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                )
            }
        )
    private String id;
    @Column(name ="user_id")
    private String user_id;
    @Column(name ="phone")
    private String phone;
    @Column(name ="email")
    private String email;
    @Column(name ="day")
    private int day;
    @Column(name ="time")
    private int time;
    @Column(name ="create_time")
    private Date create_time;
    @Column(name ="update_time")
    private Date update_time;
    @Column(name ="minpoint")
    private int minpoint;
    @Column(name ="maxpoint")
    private int maxpoint;
    @Column(name ="minisfalse")
    private int minisfalse;
    @Column(name ="maxisfalse")
    private int maxisfalse;
    @Column(name ="keywords")
    private String keywords;

    public int getMinpoint() {
        return minpoint;
    }

    public void setMinpoint(int minpoint) {
        this.minpoint = minpoint;
    }

    public int getMaxpoint() {
        return maxpoint;
    }

    public void setMaxpoint(int maxpoint) {
        this.maxpoint = maxpoint;
    }

    public int getMinisfalse() {
        return minisfalse;
    }

    public void setMinisfalse(int minisfalse) {
        this.minisfalse = minisfalse;
    }

    public int getMaxisfalse() {
        return maxisfalse;
    }

    public void setMaxisfalse(int maxisfalse) {
        this.maxisfalse = maxisfalse;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
