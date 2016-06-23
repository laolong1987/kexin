<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gaoyang
  Date: 16/2/29
  Time: 上午1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="add" method="post">
    <input type="hidden" name="id" id="id" />
<dl>
    <dt>新增</dt>
    <dd>name:<input id="name" name="name" type="text"></dd>
    <dd><input type="submit" title="提交"/><input type="reset" title="重置"/></dd>
</dl>
</form>
    <dl>
        <dt>查询</dt>
        <c:forEach items="${list}" var="l">
            <dd>name:${l.name}
                <input type="button"  onclick="update('${l.id}','${l.name}')" title="修改" value="update" />
            <input type="button" value="del" onclick="del('${l.id}')" title="删除"/>
            </dd>
        </c:forEach>
    </dl>


<dl>
    <dt>ajax提交</dt>
     <input type="button" value="save" onclick="save('1','zhangsan')" title="删除"/>

</dl>
</body>
<script type="text/javascript" src='../js/jquery.min.js'></script>
<script type="text/javascript">

    function del(id){
        $.ajax({
            type : "POST",
            url : "del",
            data: {id:id},
            dataType: "json",
            success : function() {
                window.location.reload();
            }
        });
    }
    function update(id,name){
        $("#id").val(id);
        $("#name").val(name);
    }

    function save(id,name){
            $.ajax({
                type : "POST",
                url : "save",
                data : {'aa':'aa','bb':'bb'},
                contentType : "application/json; charset=utf-8",
                dataType : "text",
                success : function(result) {
                    alert(222222222);
                }
            });
    }
</script>

</html>
