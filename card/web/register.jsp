<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 2022/3/18
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="css/common.css">
</head>
<body>
<div style=" height: 100vh;background-image: linear-gradient(to bottom right, #FC466B, #3F5EFB);overflow: hidden;">
    <div style="margin: 200px auto; background-color: #fff; width: 350px; height: 300px; padding: 20px; border-radius: 10px">
        <div style="margin: 20px 0; text-align: center; font-size: 24px;color: #800022"><b>用户注册</b></div>
        <div style="height: 5%" class="msg"></div>
        <form action="RegisterServlet" method="post">
            <label class="label-table" for="username">
                用户名:&nbsp;
                <input class="input-table" required type="text" name="username" placeholder="请输入用户名" id="username"/>
            </label>
            <br/>
            <label class="label-table" for="password">
                密&nbsp;码:&nbsp;
                <input class="input-table" required type="password" name="password" placeholder="请输入密码" id="password"/>
            </label>
            <br/>
            <label class="label-table" for="re_password">
                确认密码:
                <input class="input-table" required type="password" name="re_password" placeholder="请输入再次输入密码" id="re_password"/>
            </label>
            <br/>
            <label class="label-table" for="name">
                姓&nbsp;名:&nbsp;
                <input class="input-table" required type="text" name="name" placeholder="请输入姓名" id="name"/>
            </label>
            <br/>
            <input id="login-submit" type="submit" value="注册"/>
            <input id="login-register" type="button" value="返回登陆" onclick="go_login()"/>
        </form>
    </div>
</div>
</body>
</html>
<style rel="stylesheet">
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

    #login-register {
        float: left;
        text-align: center;
        margin-left: 10%;
        width: 20%;
        height: 10%;
        color: aqua;
        background-color: #ff0000;
    }
</style>
<script type="text/javascript">
    function go_login() {
        location.href = "login.jsp"
    }

</script>