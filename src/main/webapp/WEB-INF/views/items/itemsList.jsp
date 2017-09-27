<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>商品列表</title>
    <script type="text/javascript">

        function queryItems() {
            document.itemsForm.action = "<%=request.getContextPath()%>/items/queryItemsList";
            document.itemsForm.submit();
        }

        function addItems() {
            document.itemsForm.action = "<%=request.getContextPath()%>/items/addItems";
            document.itemsForm.submit();
        }

        function deleteItems() {
            document.itemsForm.action = "<%=request.getContextPath()%>/items/deleteItems";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
当前用户:${username}
<c:if test="${username!=null}">
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</c:if>
<form name="itemsForm" action="<%=request.getContextPath()%>/items/queryItemsList" method="post">
<table width="100%" border="1">
    <tr>
        <td>
            商品名称:<input type="text" id="name" name="itemsCustom.name"/>
        </td>
        <td>
            商品类型:
            <select name="itemtype">
                <c:forEach items="${itemtypes}" var="itemtype">
                    <option value="${itemtype.key}">${itemtype.value}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <input type="button" value="查询" onclick="queryItems();"/>
            &nbsp;&nbsp;
            <input type="button" value="新增" onclick="addItems();"/>
            &nbsp;&nbsp;
            <input type="button" value="批量删除" onclick="deleteItems();"/>
        </td>
    </tr>
</table>
<table width="100%" border="1">
    <tr>
        <td>选择</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>操作</td>
    </tr>
<c:forEach items="${itemsList}" var="item">
    <tr>
        <td><input type="checkbox" name="ids" value="${item.id}"/></td>
        <td>${item.name}</td>
        <td>${item.price}</td>
        <td><a href="<%=request.getContextPath()%>/items/editItems?id=${item.id}">修改</a></td>
    </tr>
</c:forEach>
</form>
</table>
</body>
</html>
