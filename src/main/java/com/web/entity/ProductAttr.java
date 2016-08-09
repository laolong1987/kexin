package com.web.entity;

/**
 * Created by gaoyang on 16/8/9.
 */
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_ATTR")
public class ProductAttr{
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid")
@Column(name = "id")
private int id;
@Column(name ="template_id")
private int template_id;
@Column(name ="is_required")
private String is_required;
@Column(name ="display_position")
private String display_position;
@Column(name ="display_name")
private String display_name;
@Column(name ="description")
private String description;
@Column(name ="input_type")
private String input_type;
@Column(name ="extra_info")
private String extra_info;
@Column(name ="is_show")
private int is_show;
@Column(name ="draft_field_name")
private String draft_field_name;
@Column(name ="sequence")
private int sequence;
@Column(name ="update_time")
private Date update_time;
public void setId(int id){
        this.id=id;
        }
public int getId(){
        return this.id;
        }

public void setTemplate_id(int template_id){
        this.template_id=template_id;
        }
public int getTemplate_id(){
        return this.template_id;
        }

public void setIs_required(String is_required){
        this.is_required=is_required;
        }
public String getIs_required(){
        return this.is_required;
        }

public void setDisplay_position(String display_position){
        this.display_position=display_position;
        }
public String getDisplay_position(){
        return this.display_position;
        }

public void setDisplay_name(String display_name){
        this.display_name=display_name;
        }
public String getDisplay_name(){
        return this.display_name;
        }

public void setDescription(String description){
        this.description=description;
        }
public String getDescription(){
        return this.description;
        }

public void setInput_type(String input_type){
        this.input_type=input_type;
        }
public String getInput_type(){
        return this.input_type;
        }

public void setExtra_info(String extra_info){
        this.extra_info=extra_info;
        }
public String getExtra_info(){
        return this.extra_info;
        }

public void setIs_show(int is_show){
        this.is_show=is_show;
        }
public int getIs_show(){
        return this.is_show;
        }

public void setDraft_field_name(String draft_field_name){
        this.draft_field_name=draft_field_name;
        }
public String getDraft_field_name(){
        return this.draft_field_name;
        }

public void setSequence(int sequence){
        this.sequence=sequence;
        }
public int getSequence(){
        return this.sequence;
        }

public void setUpdate_time(Date update_time){
        this.update_time=update_time;
        }
public Date getUpdate_time(){
        return this.update_time;
        }

        }

