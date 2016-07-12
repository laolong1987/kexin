package com.web.model;

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


    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    private List<String> productimg;

    private Integer authorize;

    private List<RepWebSite> webSiteList;

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
