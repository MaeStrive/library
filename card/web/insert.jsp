<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 2022/3/19
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加名片</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/nav.css">
</head>
<body>
<div class="container-all">
    <div style="height:65px">
        <a href="index.jsp"><img style="margin-left: 15%" src="img/mingpian.png"/></a>
        <a href="insert.jsp"><img style="margin-bottom: 5px" src="img/tianjiamingpian.png"/></a>
    </div>
    <%@include file="nav.jsp" %>
    <div class="container">
        <div style="margin: 0 auto; background-color: rgb(217,217,217); width: 350px; height: 400px; padding: 20px; border-radius: 10px">
            <div style="margin: 20px 0; text-align: center; font-size: 24px;color: #800022"><b>名片添加</b></div>
            <form action="InsertCardServlet" method="post">
                <label class="label-table" for="name">
                    姓&nbsp;名:&nbsp;
                    <input class="input-table" required type="text" name="name" placeholder="姓名" id="name"/>
                </label>
                <br/>
                <label class="label-table" for="account">
                    账&nbsp;户:&nbsp;
                    <input class="input-table" required type="text" name="account" placeholder="请输入账户" id="account"/>
                </label>
                <br/>
                <label class="label-table" for="password">
                    密&nbsp;码:&nbsp;
                    <input class="input-table" required type="password" name="password" placeholder="请输入密码"
                           id="password"/>
                </label>
                <br/>
                <label class="label-table" for="gender">
                    姓&nbsp;别:&nbsp;
                    <input class="input-table" required type="text" name="gender" placeholder="请输入性别" id="gender"/>
                </label>
                <label class="label-table" for="email">
                    邮&nbsp;箱:&nbsp;
                    <input class="input-table" required type="text" name="email" placeholder="请输入邮箱" id="email"/>
                </label>
                <br/>
                <br/>
                <input id="login-submit" type="submit" value="添加"/>
            </form>
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
        background-color: rgb(247, 247, 247);
    }

    .input-table {
        height: 35px;
        width: 80%;
        margin-bottom: 3%;
        text-align: center;
    }

    #login-submit {
        float: left;
        text-align: center;
        margin-left: 20%;
        width: 15%;
        height: 10%;
        color: aqua;
        background-color: #ff0000;
    }
</style>
