package com.web.model;

/**
 * Created by sukey on 2016/7/10.
 */

import java.util.Date;


public class Warings {


    private String title;

    private String enterprise;

    private String product;

    private String content;

    private String publish_department;

    private String  publish_time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublish_department() {
        return publish_department;
    }

    public void setPublish_department(String publish_department) {
        this.publish_department = publish_department;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }
}
