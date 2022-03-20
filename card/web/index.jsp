<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 2022/3/17
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>名片管理系统</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/nav.css">
</head>
<body>
<div class="container-all">
    <div style="height:65px">
        <a href="index.jsp"><img style="margin-left: 15%" src="img/mingpian.png"/></a>
        <a href="manage.jsp"><img style="margin-bottom: 5px" src="img/yiqiguanli.png"/></a>
    </div>
    <%@include file="nav.jsp" %>
    <div class="container">
        <c:if test="${user.role=='0'}">
            <img style="position: absolute;left: 25%;top: 25%" src="img/index0.png">
        </c:if>
        <c:if test="${user.role=='1'}">
            <img style="position: absolute;left: 35%;top: 25%" src="img/index1.png">
        </c:if>
    </div>
</div>
</body>
</html>
<style rel="stylesheet">

    .container-all {
        width: 100%;
        height: 648px;
    }

    .container {
        width: 1200px;
        margin: 0 auto;
        height: 100%;
    }
</style>
