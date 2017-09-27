<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>新增商品</title>
</head>
<body>
<form id="itemsForm" action="<%=request.getContextPath()%>/items/saveAdd" method="post">
    <table width="100%" border="1">
        <tr>
            <td>商品名称:</td>
            <td><input type="text" id="name" name="itemsInfo['name']" value=""/></td>
        </tr>
        <tr>
            <td>商品价格:</td>
            <td><input type="text" id="price" name="itemsInfo['price']" value=""/></td>
        </tr>
        <tr>
            <td>上线日期:</td>
            <td><input type="text" id="createTime" name="itemsInfo['createTime']" value=""/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="保存>>"/></td>
        </tr>
    </table>
</form>
</table>
</body>
</html>
