<%--
  Created by IntelliJ IDEA.
  User: gaoyang
  Date: 16/7/20
  Time: 下午9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="common.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>查看商品评论  </title>
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
                当前位置：查看商品评论
            </div>
            <div class="tian"></div>
            <div class="edit_table">
                <form action="showproductdetail" id="myform" name="myform" method="post">
                    <input type="hidden" value="1" id="page" name="page"/>
                    <input type="hidden" value="${productid}" id="id" name="id" />
                    </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="20%" align="right">商品名称：</td>
                        <td>${product.GENERIC_NAME}</td>
                    </tr>
                    <tr>
                        <td align="right">企业名称：</td>
                        <td>${product.SERVICE_SECTOR}</td>
                    </tr>
                    <tr>
                        <td align="right">评分：</td>
                        <td colspan="3">
                            <c:if test="${product.FS==0}">
                                <img src="${ctx}/images/wjx-0.png">
                            </c:if>
                            <c:if test="${product.FS==1}">
                                <img src="${ctx}/images/wjx-1.png">
                            </c:if>
                            <c:if test="${product.FS==2}">
                                <img src="${ctx}/images/wjx-2.png">
                            </c:if>
                            <c:if test="${product.FS==3}">
                                <img src="${ctx}/images/wjx-3.png">
                            </c:if>
                            <c:if test="${product.FS==4}">
                                <img src="${ctx}/images/wjx-4.png">
                            </c:if>
                            <c:if test="${product.FS==5}">
                                <img src="${ctx}/images/wjx.png">
                            </c:if>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="tian"></div>
            <div class="edit_table">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr class="trbg">
                        <td>用户</td>
                        <td>评分</td>
                        <td>评价时间</td>
                        <td>评论</td>
                    </tr>
                    <c:forEach var="ls" items="${list}">
                    <tr>
                        <td>${ls.NAME}</td>
                        <td>
                            <c:if test="${ls.POINT==0}">
                                <img src="${ctx}/images/wjx-0.png">
                            </c:if>
                            <c:if test="${ls.POINT==1}">
                                <img src="${ctx}/images/wjx-1.png">
                            </c:if>
                            <c:if test="${ls.POINT==2}">
                                <img src="${ctx}/images/wjx-2.png">
                            </c:if>
                            <c:if test="${ls.POINT==3}">
                                <img src="${ctx}/images/wjx-3.png">
                            </c:if>
                            <c:if test="${ls.POINT==4}">
                                <img src="${ctx}/images/wjx-4.png">
                            </c:if>
                            <c:if test="${ls.POINT==5}">
                                <img src="${ctx}/images/wjx.png">
                            </c:if>
                        </td>
                        <td>${ls.CREATE_TIME}</td>
                        <td>${ls.DIRECTIONS}</td>
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