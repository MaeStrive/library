<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 2022/3/19
  Time: 7:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="nav">
    <c:if test="${user.role=='0'}">
        <div class="wel">欢迎:<b>${user.name}</b></div>
    </c:if>
    <c:if test="${user.role=='1'}">
        <div class="wel">尊敬的:<b>${user.name}</b></div>
    </c:if>
    <ul>
        <li style="color: rgba(42,36,36,0.21);background-image: linear-gradient(to bottom right, #FC466B, #3F5EFB);">
            <a href="manage.jsp">名牌管理</a>
        </li>
        <li style="background-image: linear-gradient(to bottom right, rgb(255,255,255), #044804);"><a
                href="insert.jsp">添加名片</a>
        </li>
        <li style="color: #2d374b;background-image: linear-gradient(to bottom right, #46fcdb, #1834be);"><a
                href="waste.jsp">回收站</a>
        <li style="background-image: linear-gradient(to bottom right, rgba(255,229,125,0.39), #ffffff);"><a
                href="NoN">未开放</a>
        </li>
        <li style="background-image: linear-gradient(to bottom right, rgba(255,229,125,0.39), #ffffff);"><a
                href="NoN">未开放</a>
        </li>
        <li style="color: #3F5EFB;background-image: linear-gradient(to bottom right, #ece805, #03d520);"><a
                href="info.jsp">用户信息</a>
        </li>
        <li style="color: black;background-image: linear-gradient(to bottom right, #d71212, #fbb93f);"><a
                href="LogoutServlet">注销</a>
        </li>
    </ul>
</div>
</body>
</html>
