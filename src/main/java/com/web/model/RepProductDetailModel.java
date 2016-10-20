package com.web.model;

import java.util.Date;
import java.util.List;

/**
 * Created by gaoyang on 16/7/9.
 */
public class RepProductDetailModel {
    private String productname;
    private String brands;
    private String companyname;
    private String campanyaddress;
    private String license;
    private String evaluation;
    private String iscollect;
    private String iscomment;

    private Date passtime;

    public Date getPasstime() {
        return passtime;
    }

    public void setPasstime(Date passtime) {
        this.passtime = passtime;
    }

    public String getIscomment() {
        return iscomment;
    }

    public void setIscomment(String iscomment) {
        this.iscomment = iscomment;
    }

    private List<String> productimg;

    private Integer authorize;

    private List<RepWebSite> webSiteList;

    private List<Attr> attrList;

    public List<Attr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<Attr> attrList) {
        this.attrList = attrList;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getIscollect() {
        return iscollect;
    }

    public void setIscollect(String iscollect) {
        this.iscollect = iscollect;
    }

    public List<RepWebSite> getWebSiteList() {
        return webSiteList;
    }

    public void setWebSiteList(List<RepWebSite> webSiteList) {
        this.webSiteList = webSiteList;
    }

    public Integer getAuthorize() {
        return authorize;
    }

    public void setAuthorize(Integer authorize) {
        this.authorize = authorize;
    }

    public List<String> getProductimg() {
        return productimg;
    }

    public void setProductimg(List<String> productimg) {
        this.productimg = productimg;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCampanyaddress() {
        return campanyaddress;
    }

    public void setCampanyaddress(String campanyaddress) {
        this.campanyaddress = campanyaddress;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
