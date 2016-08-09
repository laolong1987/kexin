package com.web.model;

import java.util.List;

/**
 * Created by sukey on 2016/7/9.
 */
public class EnterpriseDetailModel {

    private String com_name;

    private String role_type;

    private String reg_address;

    private String address;

    private String is_manu_import;

    private String reg_on;

    private String law_person;

    private String lp_phone;

    private String reg_capital;

    private String found_date;

    private String annual_check;

    private String reg_branch;

    private String valid_period;

    private String reg_certificate;

    private boolean have_site;

    private String site_icp_no;

    private String domain;

    private String site_in_charge;

    private String site_issue_date;

    private String real_business_scope;

    private List<CertificateModel> certificateModels;

    private boolean collected;

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public String getReg_address() {
        return reg_address;
    }

    public void setReg_address(String reg_address) {
        this.reg_address = reg_address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIs_manu_import() {
        return is_manu_import;
    }

    public void setIs_manu_import(String is_manu_import) {
        this.is_manu_import = is_manu_import;
    }

    public String getReg_on() {
        return reg_on;
    }

    public void setReg_on(String reg_on) {
        this.reg_on = reg_on;
    }

    public String getLaw_person() {
        return law_person;
    }

    public void setLaw_person(String law_person) {
        this.law_person = law_person;
    }

    public String getLp_phone() {
        return lp_phone;
    }

    public void setLp_phone(String lp_phone) {
        this.lp_phone = lp_phone;
    }

    public String getReg_capital() {
        return reg_capital;
    }

    public void setReg_capital(String reg_capital) {
        this.reg_capital = reg_capital;
    }

    public String getFound_date() {
        return found_date;
    }

    public void setFound_date(String found_date) {
        this.found_date = found_date;
    }

    public String getAnnual_check() {
        return annual_check;
    }

    public void setAnnual_check(String annual_check) {
        this.annual_check = annual_check;
    }

    public String getReg_branch() {
        return reg_branch;
    }

    public void setReg_branch(String reg_branch) {
        this.reg_branch = reg_branch;
    }

    public String getValid_period() {
        return valid_period;
    }

    public void setValid_period(String valid_period) {
        this.valid_period = valid_period;
    }

    public List<CertificateModel> getCertificateModels() {
        return certificateModels;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public void setCertificateModels(List<CertificateModel> certificateModels) {
        this.certificateModels = certificateModels;
    }

    public String getReg_certificate() {
        return reg_certificate;
    }

    public void setReg_certificate(String reg_certificate) {
        this.reg_certificate = reg_certificate;
    }

    public boolean isHave_site() {
        return have_site;
    }

    public void setHave_site(boolean have_site) {
        this.have_site = have_site;
    }

    public String getSite_icp_no() {
        return site_icp_no;
    }

    public void setSite_icp_no(String site_icp_no) {
        this.site_icp_no = site_icp_no;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSite_in_charge() {
        return site_in_charge;
    }

    public void setSite_in_charge(String site_in_charge) {
        this.site_in_charge = site_in_charge;
    }

    public String getSite_issue_date() {
        return site_issue_date;
    }

    public void setSite_issue_date(String site_issue_date) {
        this.site_issue_date = site_issue_date;
    }

    public String getReal_business_scope() {
        return real_business_scope;
    }

    public void setReal_business_scope(String real_business_scope) {
        this.real_business_scope = real_business_scope;
    }
}
