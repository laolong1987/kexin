package com.web.model;

import java.util.List;

/**
 * Created by sukey on 2016/7/12.
 */
public class CertificateModel {

    private String certificate_name;

    private String permit_name;

    private String valid_period;

    private String issue_date;

    private String issue_branch;

    private String certificateNo;

    private List<String> certificateImg;

    private String range;


    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public String getPermit_name() {
        return permit_name;
    }

    public void setPermit_name(String permit_name) {
        this.permit_name = permit_name;
    }

    public String getValid_period() {
        return valid_period;
    }

    public void setValid_period(String valid_period) {
        this.valid_period = valid_period;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getIssue_branch() {
        return issue_branch;
    }

    public void setIssue_branch(String issue_branch) {
        this.issue_branch = issue_branch;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public List<String> getCertificateImg() {
        return certificateImg;
    }

    public void setCertificateImg(List<String> certificateImg) {
        this.certificateImg = certificateImg;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
