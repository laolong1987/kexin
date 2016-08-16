package com.web.entity;

/**
 * Created by sukey on 2016/8/14.
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
@Table(name = "FILE_LIST")
public class FileList {

    @Column(name = "record_no")
    private String record_no;
    @Column(name = "certificate_order")
    private int certificate_order;
    @Column(name = "file_order")
    private int file_order;
    @Column(name = "file_path")
    private String file_path;

    @Id
    @Column(name = "h_id")
    private String h_id;
    @Column(name = "notes")
    private String notes;

    public void setRecord_no(String record_no) {
        this.record_no = record_no;
    }

    public String getRecord_no() {
        return this.record_no;
    }

    public void setCertificate_order(int certificate_order) {
        this.certificate_order = certificate_order;
    }

    public int getCertificate_order() {
        return this.certificate_order;
    }

    public void setFile_order(int file_order) {
        this.file_order = file_order;
    }

    public int getFile_order() {
        return this.file_order;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_path() {
        return this.file_path;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
    }

    public String getH_id() {
        return this.h_id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return this.notes;
    }

}
