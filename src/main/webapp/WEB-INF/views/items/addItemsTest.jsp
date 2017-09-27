<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>新增商品</title>
</head>
<body>
<form id="itemsForm" action="<%=request.getContextPath()%>/items/saveAddTest" method="post">
    <table width="100%" border="1">
        <tr>
            <td>商品名称:</td>
            <td><input type="text" id="itemName" name="itemName" value=""/></td>
        </tr>
        <tr>
            <td>商品价格:</td>
            <td><input type="text" id="itemPrice" name="itemPrice" value=""/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="保存>>"/></td>
        </tr>
    </table>
</form>
</table>
</body>
</html>
