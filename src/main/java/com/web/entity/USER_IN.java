package com.web.entity;

/**
 * Created by sukey on 2016/7/3.
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
@Table(name = "USER_IN")
public class USER_IN {

    @Id
    @Column(name = "uesername")
    private String uesername;
    @Column(name = "password")
    private String password;
    @Column(name = "pw_question")
    private String pw_question;
    @Column(name = "pw_answer")
    private String pw_answer;
    @Column(name = "role_type")
    private String role_type;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "validate_code")
    private String validate_code;
    @Column(name = "key_id")
    private String key_id;

    public void setUesername(String uesername) {
        this.uesername = uesername;
    }

    public String getUesername() {
        return this.uesername;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPw_question(String pw_question) {
        this.pw_question = pw_question;
    }

    public String getPw_question() {
        return this.pw_question;
    }

    public void setPw_answer(String pw_answer) {
        this.pw_answer = pw_answer;
    }

    public String getPw_answer() {
        return this.pw_answer;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public String getRole_type() {
        return this.role_type;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getCreate_time() {
        return this.create_time;
    }

    public void setValidate_code(String validate_code) {
        this.validate_code = validate_code;
    }

    public String getValidate_code() {
        return this.validate_code;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getKey_id() {
        return this.key_id;
    }

}
