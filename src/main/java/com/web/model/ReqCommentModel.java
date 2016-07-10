package com.web.model;

/**
 * Created by gaoyang on 16/7/10.
 */
public class ReqCommentModel {
    private String productid;
    private String userid;
    private String directions;
    private int point;
    private int isfalse;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getIsfalse() {
        return isfalse;
    }

    public void setIsfalse(int isfalse) {
        this.isfalse = isfalse;
    }
}
