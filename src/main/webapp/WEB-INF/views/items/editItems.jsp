<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>编辑商品</title>
</head>
<body>
<!--显示错误信息-->
<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="error">
        ${error.defaultMessage}
    </c:forEach>
</c:if>

<form id="itemsForm" action="<%=request.getContextPath()%>/items/saveEdit" method="post"
      enctype="multipart/form-data">
    <table width="100%" border="1">
        <input type="hidden" name="id" value="${items.id}"/>
        <tr>
            <td>商品名称:</td>
            <td><input type="text" name="name" value="${items.name}"/></td>
        </tr>
        <tr>
            <td>商品价格:</td>
            <td><input type="text" name="price" value="${items.price}"/></td>
        </tr>
        <tr>
            <td>上线日期:</td>
            <td><input type="text" name="createTime" value="<fmt:formatDate value="${items.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
        </tr>
        <tr>
            <td>商品图片:</td>
            <td>
                <c:if test="${items.pic!=null}">
                    <img src="/pic/${items.pic}" width="100" height="100">
                    </br>
                </c:if>
                <input type="file" id="itemsPic" name="itemsPic"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="保存>>"/></td>
        </tr>
    </table>
</form>
</table>
</body>
</html>
