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
        当前位置：新建警示信息
      </div>
      <div class="tian"></div>
      <div class="edit_table">
        <form name="addWaring" id="addWaring" action="${ctx}/admin/warings/add" method="post">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" align="right">标题：</td>
            <td><input name="title" type="text" class="intext" value="${waring.title}" style="width:500px;"/>
            </td>
          </tr>
          <tr>
            <td width="25%" align="right">发布单位：</td>
            <td>XXXX工商局</td>
            <input name="department" type="hidden" value="XXXX工商局">
          </tr>
          <tr>
            <td width="25%" align="right">发布时间：</td>
            <td>${publish_date}</td>
          </tr>
          <tr>
            <td width="25%" align="right">关联企业：</td>
            <td><input name="enterprise" id="enterprise" type="text" value="${waring.enterprise}" onchange="searchEnterprise()" class="intext"/><span style="margin-left:36px" id="e-tip"></span></td>

            <input type="hidden" name="eid" id="eid" value="${waring.eid}">
          </tr>
          <tr>
            <td width="25%" align="right">关联商品：</td>
            <td><input name="product" type="text"  value="${waring.product}"  class="intext"/></td>
            <input type="hidden" name="eid" id="pid" value="${waring.pid}">
          </tr>
          <tr>
            <td width="25%" align="right">内容：</td>
            <td>
              <textarea name="content"  style="width:500px;" rows="10">${waring.content}</textarea>
            </td>
          </tr>
          <input name="id" type="hidden" value="${waring.id}">
          <tr>
            <td align="right">&nbsp; </td>
            <td><input  type="submit" class="btn_cld" value="提交"/></td>
          </tr>

        </table>
        </form>
      </div>


    </div>
  </div>
</div>

<!-- 底部菜单-->
<%@include file="footer.jsp" %>
</body>

<script>
  function searchEnterprise(){
    var enterprise=$("#enterprise").val();
    $.ajax({
      url:"matchEnterprise",
      type:"POST",
      data:{"enterprise":enterprise},
      success:function(res){
        if(res!='false'){
          $("#eid").val(res);
        }else{
          $("#e-tip").text("该企业不存在");
        }
      }
    })
  }

</script>

</html>
