package com.web.entity;

/**
 * Created by sukey on 2016/6/25.
 */

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER_OUT")
public class USER_OUT {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "pw_question")
    private String pw_question;
    @Column(name = "pw_answer")
    private String pw_answer;
    @Column(name = "role_type")
    private String role_type;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "validate_code")
    private String validate_code;
    @Column(name = "sub_state")
    private String sub_state;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "address")
    private String address;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "email")
    private String email;
    @Column(name = "contact_phone")
    private String contact_phone;
    @Column(name = "mobile_phone")
    private String mobile_phone;
    @Column(name = "contact_name")
    private String contact_name;
    @Column(name = "state")
    private int state;
    @Column(name = "net_id")
    private String net_id;
    @Column(name = "location")
    private String location;
    @Column(name = "sync_time")
    private Date sync_time;
    @Column(name = "clearpassword")
    private String clearpassword;
    @Column(name = "password_with_salt")
    private String password_with_salt;
    @Column(name = "salt")
    private String salt;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPw_question(String pw_question) {
        this.pw_question = pw_question;
    }

    public String getPw_question() {
        return this.pw_question;
    }

    public void setPw_answer(String pw_answer) {
        this.pw_answer = pw_answer;
    }

    public String getPw_answer() {
        return this.pw_answer;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public String getRole_type() {
        return this.role_type;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getCreate_time() {
        return this.create_time;
    }

    public void setValidate_code(String validate_code) {
        this.validate_code = validate_code;
    }

    public String getValidate_code() {
        return this.validate_code;
    }

    public void setSub_state(String sub_state) {
        this.sub_state = sub_state;
    }

    public String getSub_state() {
        return this.sub_state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_phone() {
        return this.contact_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getMobile_phone() {
        return this.mobile_phone;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_name() {
        return this.contact_name;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }

    public void setNet_id(String net_id) {
        this.net_id = net_id;
    }

    public String getNet_id() {
        return this.net_id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setSync_time(Date sync_time) {
        this.sync_time = sync_time;
    }

    public Date getSync_time() {
        return this.sync_time;
    }

    public void setClearpassword(String clearpassword) {
        this.clearpassword = clearpassword;
    }

    public String getClearpassword() {
        return this.clearpassword;
    }

    public void setPassword_with_salt(String password_with_salt) {
        this.password_with_salt = password_with_salt;
    }

    public String getPassword_with_salt() {
        return this.password_with_salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return this.salt;
    }
}


