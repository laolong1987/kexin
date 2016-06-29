package com.web.entity;

/**
 * Created by sukey on 2016/6/26.
 */
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER_OUT_TOKEN")
public class UserOutToken{
 @Id
 @GeneratedValue(generator = "uuid")
 @GenericGenerator(name = "uuid", strategy = "uuid")
 @Column(name = "id")
 private String id;
 @Column(name ="username")
 private String username;
 @Column(name ="token")
 private String token;
 @Column(name ="oncestr")
 private String oncestr;
 @Column(name ="create_time")
 private Date create_time;
 public void setId(String id){
   this.id=id;
 }
 public String getId(){
   return this.id;
 }

 public void setUsername(String username){
   this.username=username;
 }
 public String getUsername(){
   return this.username;
 }

 public void setToken(String token){
   this.token=token;
 }
 public String getToken(){
   return this.token;
 }

 public void setOncestr(String oncestr){
   this.oncestr=oncestr;
 }
 public String getOncestr(){
   return this.oncestr;
 }

 public void setCreate_time(Date create_time){
   this.create_time=create_time;
 }
 public Date getCreate_time(){
   return this.create_time;
 }

}
