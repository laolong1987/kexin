package com.web.entity;

/**
 * Created by sukey on 2016/7/3.
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
@Table(name = "SUPERVISOR")
public class Supervisor {

    @Id
    @Column(name = "uesername")
    private String uesername;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "type")
    private String type;
    @Column(name = "gov_name")
    private String gov_name;
    @Column(name = "depart_name")
    private String depart_name;
    @Column(name = "position")
    private String position;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "county")
    private String county;
    @Column(name = "address")
    private String address;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "email")
    private String email;
    @Column(name = "contact_phone")
    private String contact_phone;
    @Column(name = "verify_status")
    private String verify_status;
    @Column(name = "verify_man")
    private String verify_man;
    @Column(name = "verify_opinion")
    private String verify_opinion;
    @Column(name = "verify_date")
    private Date verify_date;
    @Column(name = "inspect_status")
    private String inspect_status;
    @Column(name = "inspect_man")
    private String inspect_man;
    @Column(name = "inspect_opinion")
    private String inspect_opinion;
    @Column(name = "inspect_date")
    private Date inspect_date;
    @Column(name = "area_code")
    private String area_code;
    @Column(name = "record_time")
    private Date record_time;
    @Column(name = "random_code")
    private String random_code;
    @Column(name = "generate_date")
    private Date generate_date;

    public void setUesername(String uesername) {
        this.uesername = uesername;
    }

    public String getUesername() {
        return this.uesername;
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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setGov_name(String gov_name) {
        this.gov_name = gov_name;
    }

    public String getGov_name() {
        return this.gov_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public String getDepart_name() {
        return this.depart_name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return this.province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCounty() {
        return this.county;
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

    public void setVerify_status(String verify_status) {
        this.verify_status = verify_status;
    }

    public String getVerify_status() {
        return this.verify_status;
    }

    public void setVerify_man(String verify_man) {
        this.verify_man = verify_man;
    }

    public String getVerify_man() {
        return this.verify_man;
    }

    public void setVerify_opinion(String verify_opinion) {
        this.verify_opinion = verify_opinion;
    }

    public String getVerify_opinion() {
        return this.verify_opinion;
    }

    public void setVerify_date(Date verify_date) {
        this.verify_date = verify_date;
    }

    public Date getVerify_date() {
        return this.verify_date;
    }

    public void setInspect_status(String inspect_status) {
        this.inspect_status = inspect_status;
    }

    public String getInspect_status() {
        return this.inspect_status;
    }

    public void setInspect_man(String inspect_man) {
        this.inspect_man = inspect_man;
    }

    public String getInspect_man() {
        return this.inspect_man;
    }

    public void setInspect_opinion(String inspect_opinion) {
        this.inspect_opinion = inspect_opinion;
    }

    public String getInspect_opinion() {
        return this.inspect_opinion;
    }

    public void setInspect_date(Date inspect_date) {
        this.inspect_date = inspect_date;
    }

    public Date getInspect_date() {
        return this.inspect_date;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getArea_code() {
        return this.area_code;
    }

    public void setRecord_time(Date record_time) {
        this.record_time = record_time;
    }

    public Date getRecord_time() {
        return this.record_time;
    }

    public void setRandom_code(String random_code) {
        this.random_code = random_code;
    }

    public String getRandom_code() {
        return this.random_code;
    }

    public void setGenerate_date(Date generate_date) {
        this.generate_date = generate_date;
    }

    public Date getGenerate_date() {
        return this.generate_date;
    }

}
