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
    <%@include file="common.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>企业举报信息处理  </title>
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
                当前位置：企业举报信息处理
            </div>
            <div class="tian"></div>
            <div class="edit_table">
                <form action="showreportcompany" method="post">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr class="trbg">
                        <td colspan="4">检索条件 </td>
                    </tr>
                    <tr>
                        <td width="23%" align="right">企业名称：</td>
                        <td width="27%"><input name="" type="text" class="intext" id="companyname" name="companyname" value="${companyname}"/></td>
                        <td width="13%" align="right">处理状态：</td>
                        <td width="27%">
                            <select id="status" name="status">
                                <option>未处理</option>
                                <option>处理中</option>
                                <option>已处理</option>
                            </select>
                        </td>
                    <tr>
                        <td align="right">&nbsp; </td>
                        <td colspan="3"><input name="" type="submit" class="btn_cld" value="检索" /></td>
                    </tr>
                    </tr>
                </table>
                </form>
            </div>
            <div class="tian"></div>
            <div class="edit_table">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr class="trbg">
                        <td>企业名称</td>
                        <td>被举报时间</td>
                        <td>处理状态</td>
                        <td>处理时间</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach var="ls" items="${list}">
                        <tr>
                            <td>${ls.COMPANY_NAME}</td>
                            <td>${ls.CREATE_TIME}</td>
                            <td>
                                <c:if test="${ls.STATUS==0}">
                                    未处理
                                </c:if>
                                <c:if test="${ls.STATUS==1}">
                                    处理中
                                </c:if>
                                <c:if test="${ls.STATUS==2}">
                                    已处理
                                </c:if>
                            </td>
                            <td>${ls.UPDATE_TIME}</td>
                            <td><a href="updatereportcompany?id=${ls.ID}">处理</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="tian"></div>
            <div class="page_box">
                <div class="page">
                    <c:if test="${0!=page}">
                        <a class='n2 over'>首页</a>
                        <a class='n2 over'>上一页</a>
                    </c:if>

                    <%--<a class='n1 selected' >1</a>--%>
                    <%--<a class='n1' href='#'>2</a>--%>
                    <%--<a class='n1' href='#'>3</a>--%>
                    <c:forEach begin="3" end="6" varStatus="status">
                        <a class='n1' href='#'>${status.current}</a>
                    </c:forEach>
                    <c:if test="${page!=max}">
                        <a class=n2 href='#'>下一页</a>
                        <a class=n2 href='#'>末页</a>
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
</html>
