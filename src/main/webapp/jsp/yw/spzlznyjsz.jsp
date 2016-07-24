<%--
  Created by IntelliJ IDEA.
  User: gaoyang
  Date: 16/7/24
  Time: 下午5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="common.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>商品质量智能预警设置 </title>
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
                当前位置：商品质量智能预警设置
            </div>
            <div class="tian"></div>
            <div class="edit_table">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="25%" align="right">评分范围：</td>
                        <td><input name="minpoint" id="minpoint" type="text" value="${reminder.minpoint}" class="intext"style="width:30px;"/>-<input value="${reminder.maxpoint}"  name="maxpoint" id="maxpoint" type="text" class="intext"style="width:30px;"/>（注：商品评分范围为0-5分）</td>
                    </tr>
                    <tr>
                        <td align="right">被举报疑似假冒伪劣商品次数： </td>
                        <td><input name="minisfalse" id="minisfalse" value="${reminder.minisfalse}" type="text" class="intext"style="width:30px;"/>-<input name="maxisfalse" id="maxisfalse" value="${reminder.maxisfalse}"  type="text" class="intext"style="width:30px;"/></td>
                    </tr>
                    <tr>
                        <td align="right">评论关键字： </td>
                        <td><input name="keywords" value="${reminder.keywords}" id="keywords" type="text" class="intext"style="width:500px;"/>（注：多个关键字用分号分隔）</td>
                    </tr>
                    <tr>
                        <td align="right">接收邮箱地址： </td>
                        <td><input name="email" id="email" value="${reminder.email}" type="text" class="intext"/></td>
                    </tr>
                    <tr>
                        <td align="right">接收手机号码： </td>
                        <td>
                            <input name="phone" id="phone" value="${reminder.phone}" type="text" class="intext"/>
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
                        <td><input name="" type="button" onclick="submitdata()" class="btn_cld" value="提交" /></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- 底部菜单-->
<%@include file="footer.jsp"%>
</body>
<script type="text/javascript">
    $(function(){
        $("#day").val(${reminder.day});
        $("#time").val(${reminder.time});
    });


    function submitdata(){
        var email=$("#email").val();
        var time=$("#time").val();
        var day=$("#day").val();
        var phone=$("#phone").val();

        var minpoint=$("#minpoint").val();
        var maxpoint=$("#maxpoint").val();
        var minisfalse=$("#minisfalse").val();
        var maxisfalse=$("#maxisfalse").val();
        var keywords=$("#keywords").val();

        if(yanz()){
            $.ajax({
                type : "POST",
                url : "addproductreminder",
                data : {email:email,time:time,day:day,phone:phone,minpoint:minpoint,maxpoint:maxpoint,minisfalse:minisfalse,maxisfalse:maxisfalse,keywords:keywords},
                dataType : "text",
                success : function(result) {
                    alert("设置成功");
                }
            });
        }
    }
    function yanz(){
        var email=$("#email").val();
        if(""==email){
            alert("邮箱不能为空！");
            return false;
        }
        return true;
    }
</script>
</html>
