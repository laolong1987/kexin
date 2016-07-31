package com.web.entity;

/**
 * Created by sukey on 2016/7/10.
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
@Table(name = "WARINGS_INFO")
public class WaringsInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "enterprise")
    private String enterprise;
    @Column(name = "eid")
    private String eid;
    @Column(name = "product")
    private String product;
    @Column(name = "pid")
    private String pid;
    @Column(name = "content")
    private String content;
    @Column(name = "publish_department")
    private String publish_department;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "update_time")
    private Date update_time;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getEnterprise() {
        return this.enterprise;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return this.product;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setPublish_department(String publish_department) {
        this.publish_department = publish_department;
    }

    public String getPublish_department() {
        return this.publish_department;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getCreate_time() {
        return this.create_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getUpdate_time() {
        return this.update_time;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
