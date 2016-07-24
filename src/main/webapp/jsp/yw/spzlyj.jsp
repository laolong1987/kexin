<%--
  Created by IntelliJ IDEA.
  User: gaoyang
  Date: 16/7/20
  Time: 下午7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="common.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>商品收藏统计</title>
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
                当前位置：商品质量预警
            </div>
            <div class="tian"></div>
            <div class="edit_table">
                <form action="showproduct" id="myform" name="myform" method="post">
                    <input type="hidden" value="1" id="page" name="page"/>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr class="trbg">
                        <td colspan="4">检索条件 </td>
                    </tr>
                    <tr>
                        <td width="23%" align="right">商品名称：</td>
                        <td width="27%"><input name="productname" id="productname" value="${productname}" type="text" class="intext" /></td>
                        <td width="13%" align="right">企业名称：</td>
                        <td width="27%"><input name="companyname" id="companyname" value="${companyname}" type="text" class="intext" /></td>
                    </tr>
                    <tr>
                        <td align="right">评分范围：</td>
                        <td colspan="3"><input name="beginpoint" id="beginpoint"  value="${beginpoint}"  type="text" class="intext"style="width:30px;"/>-<input name="endpoint" id="endpoint" value="${endpoint}" type="text" class="intext"style="width:30px;"/>（注：商品评分范围为0-5分）</td>
                    </tr>
                    <tr>
                        <td align="right">被举报疑似假冒伪劣商品次数：</td>
                        <td colspan="3"><input name="beginfalse" id="beginfalse" value="${beginfalse}"  type="text" class="intext"style="width:30px;"/>-<input name="endfalse" id="endfalse" value="${endfalse}"  type="text" class="intext"style="width:30px;"/></td>
                    </tr>
                    <tr>
                        <td align="right">&nbsp; </td>
                        <td colspan="3"><input name="" onclick="topage('1')" type="button" class="btn_cld" value="检索" /></td>
                    </tr>
                </table>
                    </form>
            </div>
            <div class="tian"></div>
            <div class="edit_table">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr class="trbg">
                        <td>商品名称</td>
                        <td>生产企业</td>
                        <td>评分</td>
                        <td>被举报疑似假冒伪劣商品次数</td>
                        <td>操作</td>
                    </tr>
<c:forEach var="ls" items="${list}">
                    <tr>
                        <td>${ls.GENERIC_NAME}</td>
                        <td>${ls.SERVICE_SECTOR}</td>
                        <td>
                            <c:if test="${ls.FS==0}">
                                <img src="${ctx}/images/wjx-0.png">
                            </c:if>
                            <c:if test="${ls.FS==1}">
                                <img src="${ctx}/images/wjx-1.png">
                            </c:if>
                            <c:if test="${ls.FS==2}">
                                <img src="${ctx}/images/wjx-2.png">
                            </c:if>
                            <c:if test="${ls.FS==3}">
                                <img src="${ctx}/images/wjx-3.png">
                            </c:if>
                            <c:if test="${ls.FS==4}">
                                <img src="${ctx}/images/wjx-4.png">
                            </c:if>
                            <c:if test="${ls.FS==5}">
                                <img src="${ctx}/images/wjx.png">
                            </c:if>
                        </td>
                        <td>${ls.FSIZE}</td>
                        <td><a href="showproductdetail?id=${ls.ID}">查看评论</a></td>
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
