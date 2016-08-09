package com.web.model;

/**
 * Created by gaoyang on 16/8/9.
 */
public class Attr {
    private String display_name;
    private String display_position;
    private String input_type;
    private String extra_info;
    private String draft_field_name;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getDisplay_position() {
        return display_position;
    }

    public void setDisplay_position(String display_position) {
        this.display_position = display_position;
    }

    public String getInput_type() {
        return input_type;
    }

    public void setInput_type(String input_type) {
        this.input_type = input_type;
    }

    public String getExtra_info() {
        return extra_info;
    }

    public void setExtra_info(String extra_info) {
        this.extra_info = extra_info;
    }

    public String getDraft_field_name() {
        return draft_field_name;
    }

    public void setDraft_field_name(String draft_field_name) {
        this.draft_field_name = draft_field_name;
    }
}
