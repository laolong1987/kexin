<%--
  Created by IntelliJ IDEA.
  User: gaoyang
  Date: 16/7/2
  Time: 下午3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@include file="common.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>企业举报信息处理 </title>
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
                <form action="addhandle" method="post">
                    <input type="hidden" name="id" id="id" value="${reportCompany.id}">
                    <input type="hidden" name="type" id="type" value="1">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="25%" align="right">企业名称：</td>
                        <td>${reportCompany.companyName}</td>
                    </tr>
                    <tr>
                        <td width="25%" align="right">标题：</td>
                        <td>${reportCompany.title}</td>
                    </tr>
                    <tr>
                        <td width="25%" align="right">举报时间：</td>
                        <td>
                        <fmt:formatDate value="${reportCompany.create_time}" type="both" />
                            </td>
                    </tr>
                    <tr>
                        <td width="25%" align="right">举报内容：</td>
                        <td>${reportCompany.description}</td>
                    </tr>
                    <tr>
                        <td width="25%" align="right">证据（图片）：</td>
                        <td>
                            <c:forEach items="${filelist}" var="fls">
                                <c:if test="${fls.file_type==1}">
                                    <a href="${ctx}/doDownload/${fls.id}" target="_top" ><img src="${ctx}/doDownload/${fls.id}" width="200px" /></a>
                                        <br />
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%" align="right">证据（视频）：</td>
                        <td>
                            <c:forEach items="${filelist}" var="fls">
                                <c:if test="${fls.file_type==1}">
                                    <a href="${ctx}/doDownload/${fls.id}" target="_top" ><img src="${ctx}/doDownload/${fls.id}" width="200px" /></a>
                                    <br />
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%" align="right">证据（录音）：</td>
                        <td>
                            <c:forEach items="${filelist}" var="fls">
                                <c:if test="${fls.file_type==2}">
                                    <a href="${ctx}/doDownload/${fls.id}" target="_top" ><img src="${ctx}/doDownload/${fls.id}" width="200px" /></a>
                                    <br />
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">处理状态： </td>
                        <td>
                            <select id="status" name="status">
                                <option value="0">未处理</option>
                                <option value="1">处理中</option>
                                <option value="2">已处理</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">处理内容： </td>
                        <td><textarea id="description" name="description" rows="5" style="width:500px;"></textarea>
                        </td>
                    </tr>
                            <c:forEach items="${handlelist}" var="ls">
                                <tr>
                                <td align="right"> <fmt:formatDate value="${ls.create_time}" /></td>
                                <td>${ls.description}<a href="delhandle?id=${ls.id}&type=1">删除</a></td>
                                </tr>
                            </c:forEach>
                    <tr>
                        <td align="right">&nbsp; </td>
                        <td><input name="" type="submit" class="btn_cld" value="提交" /></td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 底部菜单-->
<%@include file="footer.jsp"%>
</body>
<script type="text/javascript">
    $(function(){
        $("#status").val(${reportCompany.status});
    })
</script>
</html>
