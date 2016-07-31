<%--
  Created by IntelliJ IDEA.
  User: gaoyang
  Date: 16/7/2
  Time: 下午3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="common2.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>警示信息管理 </title>
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
        当前位置：监管用户管理
      </div>
      <div class="tian"></div>

      <div style="padding-left:10px;"><a href="${ctx}/admin/supervisor/add-user"><input type="button" value="新建监管用户"  class="btn_cld" /></a></div>

      <div class="tian"></div>
      <div class="edit_table">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr class="trbg">
            <td>用户ID</td>
            <td>姓名</td>
            <td>性别</td>
            <td width="18%">单位名称</td>
            <td width="15%">所在部门</td>
            <td width="11%">邮箱</td>
            <td width="11%">手机号码</td>
          </tr>
          <c:forEach var="obj" items="${list}">
            <tr>
               <td>${obj.UESERNAME}</td>
               <td>${obj.NAME}</td>
               <td width="8%">${obj.SEX}</td>
               <td width="25%">${obj.GOV_NAME}</td>
               <td >${obj.DEPART_NAME}</td>
               <td width="15%">${obj.EMAIL}</td>
               <td width="11%">${obj.CONTACT_PHONE}</td>
             </tr>
          </c:forEach>
        </table>
      </div>

      <div class="tian"></div>
      <div class="page_box">
        <div class="page">
          <c:if test="${1!=page}">
            <a class='n2 over'
               href="${ctx}/admin/supervisor/list-warings?page=1">首页</a>
            <a class='n2 over'
               href="${ctx}/admin/supervisor/manage?page=${page-1}">上一页</a>
          </c:if>
          <c:forEach begin="${begin}" end="${end}" varStatus="status">
            <c:if test="${status.current==page}">
              <a class='n1 selected'
                 href="${ctx}/admin/supervisor/manage?page=${status.current}">${status.current}</a>
            </c:if>
            <c:if test="${status.current!=page}">
              <a class='n1'
                 href="${ctx}/admin/supervisor/manage?page=${status.current}">${status.current}</a>
            </c:if>

          </c:forEach>
          <c:if test="${page!=max}">
            <a class=n2 href="${ctx}/admin/supervisor/manage?page=${page+1}">下一页</a>
            <a class=n2
               href="${ctx}/admin/supervisor/manage?page=${max}">末页</a>
          </c:if>
        </div>

        <div class="tian"></div>

      </div>
    </div>
  </div>

  <!-- 底部菜单-->
  <%@include file="footer.jsp" %>
</body>
<script>
  function del(id) {
    $.ajax({
      url: "delete",
      type: "POST",
      data: {"wid": id},
      success: function (rest) {
        $("#" + id).remove();
        alert(rest);
      }
    })
  }

</script>

</html>
