package com.web.entity;

/**
 * Created by gaoyang on 16/6/25.
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
@Table(name = "RECORD_INFO")
public class RECORD_INFO {
    @Column(name = "username")
    private String username;
    @Column(name = "role_type")
    private String role_type;
    @Column(name = "user_type")
    private Integer user_type;
    @Id
    @Basic(optional = false)
    @Column(name = "record_no")
    private String record_no;
    @Column(name = "sws_password")
    private String sws_password;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "idcard_type")
    private String idcard_type;
    @Column(name = "idcard_no")
    private String idcard_no;
    @Column(name = "address")
    private String address;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "county")
    private String county;
    @Column(name = "area_code")
    private String area_code;
    @Column(name = "email")
    private String email;
    @Column(name = "contact_phone")
    private String contact_phone;
    @Column(name = "mobile_phone")
    private String mobile_phone;
    @Column(name = "com_name")
    private String com_name;
    @Column(name = "com_section")
    private String com_section;
    @Column(name = "com_position")
    private String com_position;
    @Column(name = "record_cert")
    private String record_cert;
    @Column(name = "reg_no")
    private String reg_no;
    @Column(name = "law_person")
    private String law_person;
    @Column(name = "lp_phone")
    private String lp_phone;
    @Column(name = "reg_capital")
    private String reg_capital;
    @Column(name = "reg_address")
    private String reg_address;
    @Column(name = "reg_branch")
    private String reg_branch;
    @Column(name = "found_date")
    private Date found_date;
    @Column(name = "valid_period")
    private Date valid_period;
    @Column(name = "annual_check")
    private String annual_check;
    @Column(name = "business_scope")
    private String business_scope;
    @Column(name = "certificate_quantity")
    private Integer certificate_quantity;
    @Column(name = "have_site")
    private String have_site;
    @Column(name = "org_type")
    private String org_type;
    @Column(name = "site_icp_no")
    private String site_icp_no;
    @Column(name = "site_dns")
    private String site_dns;
    @Column(name = "site_in_charge")
    private String site_in_charge;
    @Column(name = "site_issue_date")
    private Date site_issue_date;
    @Column(name = "site_business_scope")
    private String site_business_scope;
    @Column(name = "site_have_reguser")
    private String site_have_reguser;
    @Column(name = "is_record")
    private String is_record;
    @Column(name = "record_time")
    private Date record_time;
    @Column(name = "state")
    private Integer state;
    @Column(name = "update_state")
    private Integer update_state;
    @Column(name = "h_id")
    private String h_id;
    @Column(name = "first_time")
    private Date first_time;
    @Column(name = "last_time")
    private Date last_time;
    @Column(name = "notes")
    private String notes;
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
    @Column(name = "is_manu_import")
    private String is_manu_import;
    @Column(name = "key_words")
    private String key_words;
    @Column(name = "user_http")
    private String user_http;
    @Column(name = "vision1")
    private String vision1;
    @Column(name = "vision2")
    private String vision2;
    @Column(name = "reg_type")
    private Integer reg_type;
    @Column(name = "sj_key_id")
    private String sj_key_id;
    @Column(name = "sj_com_id")
    private String sj_com_id;
    @Column(name = "data_source")
    private Integer data_source;
    @Column(name = "reg_type_state")
    private Integer reg_type_state;
    @Column(name = "update_time_qg")
    private Date update_time_qg;
    @Column(name = "update_time_sj")
    private Date update_time_sj;
    @Column(name = "location")
    private String location;
    @Column(name = "industry")
    private String industry;
    @Column(name = "ebtrust_location")
    private String ebtrust_location;
    @Column(name = "ebtrust_sync_time")
    private Date ebtrust_sync_time;
    @Column(name = "ebtrust_is_sync")
    private Integer ebtrust_is_sync;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public String getRole_type() {
        return this.role_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public Integer getUser_type() {
        return this.user_type;
    }

    public void setRecord_no(String record_no) {
        this.record_no = record_no;
    }

    public String getRecord_no() {
        return this.record_no;
    }

    public void setSws_password(String sws_password) {
        this.sws_password = sws_password;
    }

    public String getSws_password() {
        return this.sws_password;
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

    public void setIdcard_type(String idcard_type) {
        this.idcard_type = idcard_type;
    }

    public String getIdcard_type() {
        return this.idcard_type;
    }

    public void setIdcard_no(String idcard_no) {
        this.idcard_no = idcard_no;
    }

    public String getIdcard_no() {
        return this.idcard_no;
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

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getArea_code() {
        return this.area_code;
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

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getMobile_phone() {
        return this.mobile_phone;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getCom_name() {
        return this.com_name;
    }

    public void setCom_section(String com_section) {
        this.com_section = com_section;
    }

    public String getCom_section() {
        return this.com_section;
    }

    public void setCom_position(String com_position) {
        this.com_position = com_position;
    }

    public String getCom_position() {
        return this.com_position;
    }

    public void setRecord_cert(String record_cert) {
        this.record_cert = record_cert;
    }

    public String getRecord_cert() {
        return this.record_cert;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getReg_no() {
        return this.reg_no;
    }

    public void setLaw_person(String law_person) {
        this.law_person = law_person;
    }

    public String getLaw_person() {
        return this.law_person;
    }

    public void setLp_phone(String lp_phone) {
        this.lp_phone = lp_phone;
    }

    public String getLp_phone() {
        return this.lp_phone;
    }

    public void setReg_capital(String reg_capital) {
        this.reg_capital = reg_capital;
    }

    public String getReg_capital() {
        return this.reg_capital;
    }

    public void setReg_address(String reg_address) {
        this.reg_address = reg_address;
    }

    public String getReg_address() {
        return this.reg_address;
    }

    public void setReg_branch(String reg_branch) {
        this.reg_branch = reg_branch;
    }

    public String getReg_branch() {
        return this.reg_branch;
    }

    public void setFound_date(Date found_date) {
        this.found_date = found_date;
    }

    public Date getFound_date() {
        return this.found_date;
    }

    public void setValid_period(Date valid_period) {
        this.valid_period = valid_period;
    }

    public Date getValid_period() {
        return this.valid_period;
    }

    public void setAnnual_check(String annual_check) {
        this.annual_check = annual_check;
    }

    public String getAnnual_check() {
        return this.annual_check;
    }

    public void setBusiness_scope(String business_scope) {
        this.business_scope = business_scope;
    }

    public String getBusiness_scope() {
        return this.business_scope;
    }

    public void setCertificate_quantity(Integer certificate_quantity) {
        this.certificate_quantity = certificate_quantity;
    }

    public Integer getCertificate_quantity() {
        return this.certificate_quantity;
    }

    public void setHave_site(String have_site) {
        this.have_site = have_site;
    }

    public String getHave_site() {
        return this.have_site;
    }

    public void setOrg_type(String org_type) {
        this.org_type = org_type;
    }

    public String getOrg_type() {
        return this.org_type;
    }

    public void setSite_icp_no(String site_icp_no) {
        this.site_icp_no = site_icp_no;
    }

    public String getSite_icp_no() {
        return this.site_icp_no;
    }

    public void setSite_dns(String site_dns) {
        this.site_dns = site_dns;
    }

    public String getSite_dns() {
        return this.site_dns;
    }

    public void setSite_in_charge(String site_in_charge) {
        this.site_in_charge = site_in_charge;
    }

    public String getSite_in_charge() {
        return this.site_in_charge;
    }

    public void setSite_issue_date(Date site_issue_date) {
        this.site_issue_date = site_issue_date;
    }

    public Date getSite_issue_date() {
        return this.site_issue_date;
    }

    public void setSite_business_scope(String site_business_scope) {
        this.site_business_scope = site_business_scope;
    }

    public String getSite_business_scope() {
        return this.site_business_scope;
    }

    public void setSite_have_reguser(String site_have_reguser) {
        this.site_have_reguser = site_have_reguser;
    }

    public String getSite_have_reguser() {
        return this.site_have_reguser;
    }

    public void setIs_record(String is_record) {
        this.is_record = is_record;
    }

    public String getIs_record() {
        return this.is_record;
    }

    public void setRecord_time(Date record_time) {
        this.record_time = record_time;
    }

    public Date getRecord_time() {
        return this.record_time;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return this.state;
    }

    public void setUpdate_state(Integer update_state) {
        this.update_state = update_state;
    }

    public Integer getUpdate_state() {
        return this.update_state;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
    }

    public String getH_id() {
        return this.h_id;
    }

    public void setFirst_time(Date first_time) {
        this.first_time = first_time;
    }

    public Date getFirst_time() {
        return this.first_time;
    }

    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

    public Date getLast_time() {
        return this.last_time;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return this.notes;
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

    public void setIs_manu_import(String is_manu_import) {
        this.is_manu_import = is_manu_import;
    }

    public String getIs_manu_import() {
        return this.is_manu_import;
    }

    public void setKey_words(String key_words) {
        this.key_words = key_words;
    }

    public String getKey_words() {
        return this.key_words;
    }

    public void setUser_http(String user_http) {
        this.user_http = user_http;
    }

    public String getUser_http() {
        return this.user_http;
    }

    public void setVision1(String vision1) {
        this.vision1 = vision1;
    }

    public String getVision1() {
        return this.vision1;
    }

    public void setVision2(String vision2) {
        this.vision2 = vision2;
    }

    public String getVision2() {
        return this.vision2;
    }

    public void setReg_type(Integer reg_type) {
        this.reg_type = reg_type;
    }

    public Integer getReg_type() {
        return this.reg_type;
    }

    public void setSj_key_id(String sj_key_id) {
        this.sj_key_id = sj_key_id;
    }

    public String getSj_key_id() {
        return this.sj_key_id;
    }

    public void setSj_com_id(String sj_com_id) {
        this.sj_com_id = sj_com_id;
    }

    public String getSj_com_id() {
        return this.sj_com_id;
    }

    public void setData_source(Integer data_source) {
        this.data_source = data_source;
    }

    public Integer getData_source() {
        return this.data_source;
    }

    public void setReg_type_state(Integer reg_type_state) {
        this.reg_type_state = reg_type_state;
    }

    public Integer getReg_type_state() {
        return this.reg_type_state;
    }

    public void setUpdate_time_qg(Date update_time_qg) {
        this.update_time_qg = update_time_qg;
    }

    public Date getUpdate_time_qg() {
        return this.update_time_qg;
    }

    public void setUpdate_time_sj(Date update_time_sj) {
        this.update_time_sj = update_time_sj;
    }

    public Date getUpdate_time_sj() {
        return this.update_time_sj;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustry() {
        return this.industry;
    }

    public void setEbtrust_location(String ebtrust_location) {
        this.ebtrust_location = ebtrust_location;
    }

    public String getEbtrust_location() {
        return this.ebtrust_location;
    }

    public void setEbtrust_sync_time(Date ebtrust_sync_time) {
        this.ebtrust_sync_time = ebtrust_sync_time;
    }

    public Date getEbtrust_sync_time() {
        return this.ebtrust_sync_time;
    }

    public void setEbtrust_is_sync(Integer ebtrust_is_sync) {
        this.ebtrust_is_sync = ebtrust_is_sync;
    }

    public Integer getEbtrust_is_sync() {
        return this.ebtrust_is_sync;
    }

}