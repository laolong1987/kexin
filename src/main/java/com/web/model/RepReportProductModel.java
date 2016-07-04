package com.web.model;

import java.util.List;

/**
 * Created by gaoyang on 16/6/29.
 */
public class RepReportProductModel {

    private String company_name;
    private String product_name;
    private String title;
    private String description;
    private String uuid;
    private String code;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private List<FileModel> fileidlist;

    public List<FileModel> getFileidlist() {
        return fileidlist;
    }

    public void setFileidlist(List<FileModel> fileidlist) {
        this.fileidlist = fileidlist;
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
}
