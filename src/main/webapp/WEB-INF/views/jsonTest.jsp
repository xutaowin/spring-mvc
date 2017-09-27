<%--
  Created by IntelliJ IDEA.
  User: XUTAO
  Date: 2016/11/27
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>json交互测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.6.min.js"/>
    <script type="text/javascript">
    </script>


</head>
<body>
<input type="button" onclick="requestJson()" value="请求的是json串,输出json"/>
<input type="button" onclick="requestKeyValue()" value="请求的是key/value,输出json"/>
</body>
<script type="text/javascript">
    //请求的是json，输出的是json
    function requestJson() {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/requestJson',
            contentType:'application/json;charset=utf-8',
            //数据格式是json串
            data:'{"name":"手机","price":999}',
            success:function (data) {//返回json结果
                alert(data);
            }
        });
    }
    //请求的是key/value，输出的是json
    function requestKeyValue() {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/requestKeyValue',
            //contentType:'application/json;charset=utf-8',
            //数据格式是json串
            //data:'{"itemName":"手机","itemPrice":999}',
            data:'name="手机"&price=999',
            success:function (data) {//返回json结果
                alert(data);
            }
        });
    }
</script>

</html>
