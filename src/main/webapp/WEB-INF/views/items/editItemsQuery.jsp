<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>商品列表</title>
    <script type="text/javascript">

        function batchEditItems() {
            document.itemsForm.action = "<%=request.getContextPath()%>/items/batchEditItems";
            document.itemsForm.submit();
        }

    </script>
</head>
<body>
<form name="itemsForm" action="<%=request.getContextPath()%>/items/batchEditItems" method="post">
<table width="100%" border="1">
    <tr>
        <td>
            <input type="button" value="批量修改" onclick="batchEditItems();"/>
        </td>
    </tr>
</table>
<table width="100%" border="1">
    <tr>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>上线日期</td>
    </tr>
<c:forEach items="${itemsList}" var="item" varStatus="status">
    <tr>
        <%--itemsList是包装pojo中的List属性名称 ${status.index} 下标从0开始 itemName是List中pojo的属性的名称--%>
        <td><input type="text" id="name" name="itemsList[${status.index}].name" value="${item.name}"/></td>
        <td><input type="text" id="price" name="itemsList[${status.index}].price" value="${item.price}"/></td>
        <td><input type="text" id="createTime" name="itemsList[${status.index}].createTime" value="<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
    </tr>
</c:forEach>
</form>
</table>
</body>
</html>
