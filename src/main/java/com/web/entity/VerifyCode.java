package com.web.entity;

/**
 * Created by sukey on 2016/6/28.
 */

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "VERIFY_CODE")
public class VerifyCode{
 @Id
 @GeneratedValue(generator = "uuid")
 @GenericGenerator(name = "uuid", strategy = "uuid")
 @Column(name = "id")
 private String id;
 @Column(name ="phone")
 private String phone;
 @Column(name ="code")
 private String code;
 @Column(name ="used")
 private int used;
 @Column(name ="create_time")
 private Date create_time;
 public void setId(String id){
   this.id=id;
 }
 public String getId(){
   return this.id;
 }

 public void setPhone(String phone){
   this.phone=phone;
 }
 public String getPhone(){
   return this.phone;
 }

 public void setCode(String code){
   this.code=code;
 }
 public String getCode(){
   return this.code;
 }

 public void setUsed(int used){
   this.used=used;
 }
 public int getUsed(){
   return this.used;
 }

 public void setCreate_time(Date create_time){
   this.create_time=create_time;
 }
 public Date getCreate_time(){
   return this.create_time;
 }

}
