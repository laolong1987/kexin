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
  <title>企业举报信息处理 </title>
</head>
<body>
<!-- 头部 -->
<%@include file="top.jsp" %>

<div class="bodymain">
  <div class="bodycon">
    <!-- 左边菜单 -->
    <c:if test="${role_type==1}">
        <%@include file="left2.jsp" %>
    </c:if>

    <c:if test="${role_type==2}">
        <%@include file="left.jsp" %>
    </c:if>


    <div class="edit_right">
      <div class="eh2title">
        当前位置：个人信息
      </div>
      <div class="tian"></div>
      <form name="persionalInfo" action="${ctx}/admin/user/modify-personal" method="post">
      <div class="edit_table">


        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr class="trbg">
            <td colspan="4">修改个人信息</td>
          </tr>
          <c:if test="${role_type==1}">
            <tr>
              <td width="17%" align="right">姓名：</td>
              <td width="30%"><input name="name" type="text" class="intext"
                                     value="${personal.name}"/></td>
              <td width="22%" align="right">手机号：</td>
              <td width="31%"><input name="phone" type="text" class="intext" value="${personal.contact_phone}"/></td>
            </tr>
            <tr>
              <td width="17%" align="right">邮箱：</td>
              <td width="30%"><input name="email" type="text" class="intext"
                                     value="${personal.email}"/></td>
              <td width="22%" align="right"></td>
              <td width="31%"></td>
            </tr>

          </c:if>
          <c:if test="${role_type==2}">
            <tr>
              <td width="17%" align="right">姓名：</td>
              <td width="30%">
                <input name="name" type="text" class="intext" value="${personal.name}"/></td>
              <td width="22%" align="right">性别：</td>
              <td width="31%">
                <select name="gender">
                  <option value="${personal.sex}">男</option>
                  <option value="男">男</option>
                  <option value="女">女</option>
                </select>
              </td>
            </tr>
            <tr>
              <td width="17%" align="right">单位名称：</td>
              <td width="30%">
                <input name="company" type="text" class="intext"
                       value="${personal.gov_name}"/>
              </td>
              <td width="17%" align="right">所在部门：</td>
              <td width="30%">
                <input name="department" type="text" class="intext"
                       value="${personal.depart_name}"/>
              </td>
            </tr>
            <tr>
              <td width="17%" align="right">邮箱：</td>
              <td width="30%">
                <input name="email" type="text" class="intext"
                       value="${personal.email}"/></td>
              <td width="17%" align="right">手机号码：</td>
              <td width="30%">
                <input name="phone" type="text" class="intext"
                       value="${personal.contact_phone}"/></td>
            </tr>
          </c:if>
        </table>

      </div>

      <div class="tian"></div>
      <div class="edit_table">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr class="trbg">
            <td colspan="2">修改密码</td>
          </tr>
          <tr>
            <td width="17%" align="right">原密码：</td>
            <td width="83%"><input name="original" type="text" class="intext"/>
            </td>
          </tr>
          <tr>
            <td width="17%" align="right">新密码：</td>
            <td width="83%"><input name="new_pwd" type="text" class="intext"/>
            </td>
          </tr>
          <tr>
            <td width="17%" align="right">确认新密码：</td>
            <td width="83%">
              <input name="confirm_pwd" type="text" class="intext"/>
            </td>
          </tr>
          <tr>
            <td width="17%" align="right">&nbsp; </td>
            <td width="83%">
              <input name="" type="submit" class="btn_cld" value="确认修改"/></td>
          </tr>
        </table>
      </div>
      </form>

    </div>
  </div>
</div>

<!-- 底部菜单-->
<%@include file="footer.jsp" %>
</body>

<script type="text/javascript">
  function validate() {
    if ($("#username").val() == '') {
      alert("用户名不可为空");
      return false;
    }
    if ($("#name").val() == '') {
      alert("姓名不可为空");
      return false;
    }
    if ($("#company").val() == '') {
      alert("单位名称不可为空");
      return false;
    }
    if ($("#department").val() == '') {
      alert("所在部门不可为空");
      return false;
    }
    var Regex = /^(?:\w+\.?)*\w+@(?:\w+\.)*\w+$/;
    var email = $("#email").val();
    if (email == '') {
      alert("邮箱不可为空");
      return false;
    }
    if (!Regex.test(email)) {
      alert("请输入正确的邮箱地址");
      return false;
    }

    var phoneRegex = /(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
    var phone = $("#phone").val();
    if (phone == '') {
      alert("电话号码不可为空");
      return false;
    }
    if (!phoneRegex.test(phone)) {
      alert("请输入正确的电话号码");
      return false;
    }
    var validate = "false";
    $.ajax({
      url: "check-username",
      type: "POST",
      async: false,
      data: {"username": $("#username").val()},
      success: function (res) {
        validate = res;
      }
    })

    if (validate == 'false') {
      alert("用户名已存在");
      return false;
    }
    return true;

  }

</script>
</html>
