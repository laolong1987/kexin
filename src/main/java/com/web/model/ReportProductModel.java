package com.web.model;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by gaoyang on 16/6/26.
 */
public class ReportProductModel {


    private String company_name;
    private String product_name;
    private String title;
    private String description;
    private String uuid;
    private String code;
    private String user_id;
    private String address;

    private List<String> fileids;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getFileids() {
        return fileids;
    }

    public void setFileids(List<String> fileids) {
        this.fileids = fileids;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
