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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
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
    private Integer state;
    @Column(name = "key_id")
    private String key_id;
    @Column(name = "update_time_qg")
    private Date update_time_qg;
    @Column(name = "update_time_sj")
    private Date update_time_sj;
    @Column(name = "location")
    private String location;
    @Column(name = "industry")
    private String industry;
    @Column(name = "ebtrust_location")
    private String ebtrust_location;
    @Column(name = "ebtrust_sync_time")
    private Date ebtrust_sync_time;
    @Column(name = "ebtrust_is_sync")
    private Integer ebtrust_is_sync;

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

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return this.state;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getKey_id() {
        return this.key_id;
    }

    public void setUpdate_time_qg(Date update_time_qg) {
        this.update_time_qg = update_time_qg;
    }

    public Date getUpdate_time_qg() {
        return this.update_time_qg;
    }

    public void setUpdate_time_sj(Date update_time_sj) {
        this.update_time_sj = update_time_sj;
    }

    public Date getUpdate_time_sj() {
        return this.update_time_sj;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustry() {
        return this.industry;
    }

    public void setEbtrust_location(String ebtrust_location) {
        this.ebtrust_location = ebtrust_location;
    }

    public String getEbtrust_location() {
        return this.ebtrust_location;
    }

    public void setEbtrust_sync_time(Date ebtrust_sync_time) {
        this.ebtrust_sync_time = ebtrust_sync_time;
    }

    public Date getEbtrust_sync_time() {
        return this.ebtrust_sync_time;
    }

    public void setEbtrust_is_sync(Integer ebtrust_is_sync) {
        this.ebtrust_is_sync = ebtrust_is_sync;
    }

    public Integer getEbtrust_is_sync() {
        return this.ebtrust_is_sync;
    }

}
