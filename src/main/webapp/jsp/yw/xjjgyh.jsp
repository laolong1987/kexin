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
  <%@include file="common.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>企业举报信息处理 </title>
</head>
<body>
<!-- 头部 -->
<%@include file="top.jsp" %>

<div class="bodymain">
  <div class="bodycon">
    <!-- 左边菜单 -->
    <%@include file="left.jsp" %>
    <div class="edit_right">
    <div class="eh2title">
      当前位置：新建监管用户
    </div>
    <div class="tian"></div>
    <div class="edit_table">
      <form name="addSupervisor" id="addSupervisor" action="add-user" method="post">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td align="right">用户名：</td>
          <td><input name="username" type="text" class="intext"/></td>
          <td align="right">密码：</td>
          <td><input name="password" type="password" class="intext"/>（注：默认为kxpt111111）</td>
        </tr>
        <tr>
          <td align="right">姓名：</td>
          <td><input name="name" type="text" class="intext"/></td>
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
          <td><input name="company" type="text" class="intext"/></td>
          <td align="right">所在部门：</td>
          <td><input name="department" type="text" class="intext"/></td>
        </tr>
        <tr>
          <td align="right">邮箱：</td>
          <td><input name="email" type="text" class="intext"/></td>
          <td align="right">手机号码：</td>
          <td><input name="phone" type="text" class="intext"/></td>
        </tr>
        <tr>
          <td align="right">&nbsp; </td>
          <td colspan="3"><input name="" type="submit" class="btn_cld"
                                 value="提交"/></td>
        </tr>
      </table>
      </form>
      <div>添加成功</div>
    </div>
  </div>

</div>
</div>

<!-- 底部菜单-->
<%@include file="footer.jsp" %>
</body>

<script type="text/javascript">


</script>
</html>
