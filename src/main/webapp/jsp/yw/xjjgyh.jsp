<%--
  Created by IntelliJ IDEA.
  User: gaoyang
  Date: 16/6/30
  Time: 下午8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="common2.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>新建监管用户 </title>
</head>
<body>
<!-- 头部 -->
<%@include file="top.jsp" %>

<div class="bodymain">
  <div class="bodycon">
    <!-- 左边菜单 -->
    <%@include file="left2.jsp" %>
    <div class="edit_right">
    <div class="eh2title">
      当前位置：新建监管用户
    </div>
    <div class="tian"></div>
    <div class="edit_table">
      <form name="addSupervisor" id="addSupervisor" action="add-user" method="post" onsubmit="return validate()">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="right">用户名：</td>
          <td><input name="username" id="username" type="text" class="intext"/></td>
          <td align="right">密码：</td>
          <td><input name="password" type="password" class="intext"/>（注：默认为kxpt111111）</td>
        </tr>
        <tr>
          <td align="right">姓名：</td>
          <td><input name="name" id="name" type="text" class="intext"/></td>
          <td align="right">性别：</td>
          <td>
            <select name="gender">
              <option value="男" >男</option>
              <option value="女">女</option>
            </select>
          </td>
        </tr>
        <tr>
          <td align="right">单位名称：</td>
          <td><input name="company" id="company" type="text" class="intext"/></td>
          <td align="right">所在部门：</td>
          <td><input name="department" id="department" type="text" class="intext"/></td>
        </tr>
        <tr>
          <td align="right">邮箱：</td>
          <td><input name="email" id="email"  type="text" class="intext"/></td>
          <td align="right">手机号码：</td>
          <td><input name="phone" id="phone" type="text" class="intext"/></td>
        </tr>
        <tr>
          <td align="right">&nbsp; </td>
          <td colspan="3"><input type="submit" class="btn_cld" value="提交"/></td>
        </tr>
      </table>
      </form>
      <div style="color:red;margin-left: 120px;font-size: 14px;padding-top: 20px">${tip}</div>
    </div>
  </div>

</div>
</div>

<!-- 底部菜单-->
<%@include file="footer.jsp" %>
</body>

<script type="text/javascript">
function validate(){
  if($("#username").val()==''){
    alert("用户名不可为空");
    return false;
  }
  if($("#name").val()==''){
     alert("姓名不可为空");
     return false;
   }
  if($("#company").val()==''){
      alert("单位名称不可为空");
      return false;
    }
  if($("#department").val()==''){
       alert("所在部门不可为空");
       return false;
     }
  var Regex = /^(?:\w+\.?)*\w+@(?:\w+\.)*\w+$/;
  var email=$("#email").val();
  if(email==''){
    alert("邮箱不可为空");
    return false;
  }
  if(!Regex.test(email)){
        alert("请输入正确的邮箱地址");
        return false;
  }

  var phoneRegex =/(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
   var phone=$("#phone").val();
  if(phone==''){
      alert("电话号码不可为空");
      return false;
    }
    if(!phoneRegex.test(phone)){
          alert("请输入正确的电话号码");
          return false;
    }
  var validate="false";
  $.ajax({
    url:"check-username",
    type:"POST",
    async:false,
    data:{"username":$("#username").val()},
    success:function (res) {
      validate=res;
    }
  })

  if(validate=='false'){
    alert("用户名已存在");
    return false;
  }
  return true;

}

</script>
</html>
