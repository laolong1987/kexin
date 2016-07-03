<%--
  Created by IntelliJ IDEA.
  User: gaoyang
  Date: 16/7/3
  Time: 下午8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="common.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>举报信息提醒设置 </title>
</head>
<body>
<!-- 头部 -->
<%@include file="top.jsp"%>


<div class="bodymain">
    <div class="bodycon">
        <!-- 左边菜单 -->
        <%@include file="left.jsp"%>

        <div class="edit_right">
            <div class="eh2title">
                当前位置：举报信息提醒设置
            </div>
            <div class="tian"></div>
            <div class="edit_table">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="right">接收邮箱地址： </td>
                        <td><input name="email" id="email" type="text" class="intext"/></td>
                    </tr>
                    <tr>
                        <td align="right">接收手机号码： </td>
                        <td>
                            <input name="phone" id="phone" type="text" class="intext"/>
                            接收时段：
                            <select id="day" name="day">
                                <option value="1">每天</option>
                                <option value="2">周一至周五</option>
                            </select>
                            <select name="time" id="time">
                                <option value="1">00:00-24:00</option>
                                <option value="2">9:00-18:00</option>
                                <option value="3">9:00-17:00</option>
                                <option value="4">8:00-18:00</option>
                                <option value="5">8:00-17:00</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">&nbsp; </td>
                        <td><input name="" type="button" class="btn_cld" value="提交" /></td>
                    </tr>
                </table>
            </div>





        </div>
    </div>
</div>
<!-- 底部菜单-->
<%@include file="footer.jsp"%>
</body>
</html>
