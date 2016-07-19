<%--
  Created by IntelliJ IDEA.
  User: gaoyang
  Date: 16/7/19
  Time: 下午9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="common2.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>商品收藏统计  </title>
</head>
<body>
<!-- 头部 -->
<%@include file="top.jsp"%>


<div class="bodymain">
    <div class="bodycon">
        <!-- 左边菜单 -->
        <%@include file="left2.jsp"%>
        <div class="edit_right">
            <div class="eh2title">
                当前位置：商品收藏统计
            </div>
            <div class="tian"></div>
            <div class="tian"></div>
            <div class="edit_table">
                <form action="showcollectproduct" id="myform" name="myform" method="post">
                    <input type="hidden" value="1" id="page" name="page"/>
                </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr class="trbg">
                        <td>商品名称</td>
                        <td>生产企业</td>
                        <td>被收藏次数</td>
                        <td>最新收藏时间</td>
                        <td>被查看次数</td>
                        <td>最新查看时间</td>
                    </tr>
                    <c:forEach var="ls" items="${list}">
                        <tr>
                            <td>${ls.GENERIC_NAME}</td>
                            <td>${ls.SERVICE_SECTOR}</td>
                            <td>${ls.CSIZE}</td>
                            <td>${ls.ctime}</td>
                            <td>${ls.LSIZE}</td>
                            <td>${ls.ltime}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="tian"></div>
            <div class="page_box">
                <div class="page">
                    <c:if test="${1!=page}">
                        <a class='n2 over' onclick="topage('1')">首页</a>
                        <a class='n2 over' onclick="topage('${page-1}')">上一页</a>
                    </c:if>
                    <c:forEach begin="${begin}" end="${end}" varStatus="status">
                        <c:if test="${status.current==page}">
                            <a class='n1 selected' href='#' onclick="topage('${status.current}')">${status.current}</a>
                        </c:if>
                        <c:if test="${status.current!=page}">
                            <a class='n1' href='#' onclick="topage('${status.current}')">${status.current}</a>
                        </c:if>

                    </c:forEach>
                    <c:if test="${page!=max}">
                        <a class=n2 href='#' onclick="topage('${page+1}')">下一页</a>
                        <a class=n2 href='#' onclick="topage('${max}')" >末页</a>
                    </c:if>

                </div>
            </div>

            <div class="tian"></div>

        </div>
    </div>
</div>
<!-- 底部菜单-->
<%@include file="footer.jsp"%>
</body>
<script type="text/javascript">

    function topage(page){
        $("#page").val(page);
        document.getElementById("myform").submit();
    }
</script>
</html>
