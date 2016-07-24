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
        当前位置：用户管理
      </div>
      <div class="tian"></div>
      <div class="tian"></div>
      <div class="edit_table">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr class="trbg">
            <td>手机号码</td>
            <td>昵称</td>
            <td>注册时间</td>
            <td width="18%">最近登录时间</td>
            <td width="15%">收藏企业数量</td>
            <td width="11%">收藏商品数量</td>
            <td width="11%">举报次数</td>
          </tr>
          <c:forEach var="obj" items="${list}">
            <tr>
              <td>${obj.MOBILE_PHONE}</td>
              <td>${obj.NAME}</td>
              <td>${obj.CREATE_TIME}</td>
              <td width="18%">${obj.LOGIN_TIME}</td>
              <td width="15%">${obj.COLLECTEP}</td>
              <td width="11%">${obj.COLLECTGOODS}</td>
              <td width="11%">${obj.REPORTNUM}</td>
            </tr>
          </c:forEach>
        </table>
      </div>

      <div class="tian"></div>
      <div class="page_box">
        <div class="page">
          <c:if test="${1!=page}">
            <a class='n2 over' href="${ctx}/admin/warings/list-warings?page=1">首页</a>
            <a class='n2 over'
               href="${ctx}/admin/warings/list-warings?page=${page-1}">上一页</a>
          </c:if>
          <c:forEach begin="${begin}" end="${end}" varStatus="status">
            <c:if test="${status.current==page}">
              <a class='n1 selected'
                 href="${ctx}/admin/warings/list-warings?page=${status.current}">${status.current}</a>
            </c:if>
            <c:if test="${status.current!=page}">
              <a class='n1'
                 href="${ctx}/admin/warings/list-warings?page=${status.current}">${status.current}</a>
            </c:if>

          </c:forEach>
          <c:if test="${page!=max}">
            <a class=n2 href="${ctx}/admin/warings/list-warings?page=${page+1}">下一页</a>
            <a class=n2
               href=""${ctx}/admin/warings/list-warings?page=${max}">末页</a>
          </c:if>
        </div>

        <div class="tian"></div>

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
