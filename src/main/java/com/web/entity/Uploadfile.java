package com.web.entity;

/**
 * Created by gaoyang on 16/6/26.
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
@Table(name = "uploadfile")
public class Uploadfile{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;
    @Column(name ="filename")
    private String filename;
    @Column(name ="mimetype")
    private String mimetype;
    @Column(name ="uuid")
    private String uuid;
    @Column(name ="filepath")
    private String filepath;
    @Column(name ="report_type")
    private int report_type;
    @Column(name ="report_id")
    private String report_id;
    @Column(name ="type")
    private int type;
    @Column(name ="file_type")
    private int file_type;
    @Column(name ="create_time")
    private Date create_time;
    @Column(name ="update_time")
    private Date update_time;
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return this.id;
    }

    public int getFile_type() {
        return file_type;
    }

    public void setFile_type(int file_type) {
        this.file_type = file_type;
    }

    public void setFilename(String filename){
        this.filename=filename;
    }
    public String getFilename(){
        return this.filename;
    }

    public void setMimetype(String mimetype){
        this.mimetype=mimetype;
    }
    public String getMimetype(){
        return this.mimetype;
    }

    public void setUuid(String uuid){
        this.uuid=uuid;
    }
    public String getUuid(){
        return this.uuid;
    }

    public void setFilepath(String filepath){
        this.filepath=filepath;
    }
    public String getFilepath(){
        return this.filepath;
    }

    public void setReport_type(int report_type){
        this.report_type=report_type;
    }
    public int getReport_type(){
        return this.report_type;
    }

    public void setReport_id(String report_id){
        this.report_id=report_id;
    }
    public String getReport_id(){
        return this.report_id;
    }

    public void setType(int type){
        this.type=type;
    }
    public int getType(){
        return this.type;
    }

    public void setCreate_time(Date create_time){
        this.create_time=create_time;
    }
    public Date getCreate_time(){
        return this.create_time;
    }

    public void setUpdate_time(Date update_time){
        this.update_time=update_time;
    }
    public Date getUpdate_time(){
        return this.update_time;
    }

}