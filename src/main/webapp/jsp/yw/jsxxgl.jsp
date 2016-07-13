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
  <%@include file="common.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>警示信息管理 </title>
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
        当前位置：警示信息管理
      </div>
      <div class="tian"></div>
      <div style="padding-left:10px;">
        <input name="" type="button" class="btn_cld" value="新建警示信息" onclick="location='xjjsxx.html'"/>
      </div>
      <div class="tian"></div>
      <div class="edit_table">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr class="trbg">
            <td>标题</td>
            <td>发布时间</td>
            <td>发布单位</td>
            <td>操作</td>
          </tr>
          <c:forEach var="obj" items="${list}">
            <tr id="${obj.ID}">
              <td>${obj.TITLE}</td>
              <td>${obj.CREATE_TIME}</td>
              <td>${obj.PUBLISH_DEPARTMENT}</td>
              <td><a href="${ctx}/admin/warings/add?id=${obj.ID}">修改</a>&nbsp;|&nbsp;<a href="javascript:del('${obj.ID}')">删除</a></td>
            </tr>
          </c:forEach>

        </table>
      </div>

      <div class="tian"></div>
      <div class="page_box">
        <div class="page">
          <c:if test="${1!=page}">
            <a class='n2 over' href="${ctx}/admin/warings/list-warings?page=1">首页</a>
            <a class='n2 over' href="${ctx}/admin/warings/list-warings?page=${page-1}">上一页</a>
          </c:if>
          <c:forEach begin="${begin}" end="${end}" varStatus="status">
            <c:if test="${status.current==page}">
              <a class='n1 selected' href="${ctx}/admin/warings/list-warings?page=${status.current}">${status.current}</a>
            </c:if>
            <c:if test="${status.current!=page}">
              <a class='n1' href="${ctx}/admin/warings/list-warings?page=${status.current}">${status.current}</a>
            </c:if>

          </c:forEach>
          <c:if test="${page!=max}">
            <a class=n2 href="${ctx}/admin/warings/list-warings?page=${page+1}">下一页</a>
            <a class=n2 href=""${ctx}/admin/warings/list-warings?page=${max}">末页</a>
          </c:if>

        </div>
      </div>

      <div class="tian"></div>

    </div>
  </div>
</div>

<!-- 底部菜单-->
<%@include file="footer.jsp" %>
</body>
<script>
  function del(id){
    $.ajax({
      url:"delete",
      type:"POST",
      data:{"wid":id},
      success:function (rest) {
        $("#"+id).remove();
        alert(rest);
      }
    })
  }

</script>

</html>
