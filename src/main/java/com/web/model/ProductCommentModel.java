package com.web.model;

public class ProductCommentModel {

    private String directions;
    private Integer point;
    private Integer isfalse;
    private String create_time;
    private String username;
    private String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getIsfalse() {
        return isfalse;
    }

    public void setIsfalse(Integer isfalse) {
        this.isfalse = isfalse;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
