package com.web.model;

import java.util.List;

/**
 * Created by gaoyang on 16/6/29.
 */
public class RepReportCompanyDetailModel {

    private String company_name;
    private String title;
    private String description;
    private String uuid;
    private List<String> fileidlist;

    public List<String> getFileidlist() {
        return fileidlist;
    }

    public void setFileidlist(List<String> fileidlist) {
        this.fileidlist = fileidlist;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
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

}
