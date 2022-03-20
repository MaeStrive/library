<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 2022/3/19
  Time: 7:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>名片管理</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/nav.css">
</head>
<body>
<div class="container-all">
    <div style="height:65px">
        <a href="index.jsp"><img style="margin-left: 15%" src="img/mingpian.png"/></a>
        <a href="manage.jsp"><img style="margin-bottom: 5px" src="img/yonghuguanli.png"/></a>
    </div>
    <%@include file="nav.jsp" %>
    <div class="container">
        <div style="height: 5%" class="msg">${error==null?"":error}
            <c:if test="${requestScope.users==null}">
                <div class="show-card"><a href="ListUserServlet">显示用户</a></div>
            </c:if>
            <c:if test="${requestScope.users!=null}">
                <div class="form-table">
                    <form method="get" action="ListUserServletLiked">
                        <input class="text" type="text" name="likedName" placeholder="根据姓名查询指定用户">
                        <input class="btn-submit" type="submit" value="查询">
                    </form>
                </div>
                <table class="tftable" style="width: 50%;">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>姓名</th>
                        <th>账号</th>
                        <th>密码</th>
                        <th class="delete">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td class="delete" onclick="deleteUser(${user.id})">删除</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
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

    .show-card {
        height: 200px;
        width: 200px;
        font-size: 50px;
        font-family: 隶书;
        color: #FC466B;
        position: absolute;
        top: 40%;
        left: 40%;
    }

    th {
        color: #cd0200;
    }

    td {
        text-align: center;
        color: darkorange;
    }

    table {
        position: absolute;
        left: 25%;
        top: 25%;
        border: black solid 1px;
    }

    .msg {
        text-align: center;
        margin-bottom: 2%;
        color: red;
    }

    .form-table {
        position: absolute;
        top: 20%;
        left: 25%;
    }

    .text {
        height: 30px;
    }

    .btn-submit {
        background-color: deepskyblue;
    }

    .delete {
        background-color: #a108ee;
    }

</style>
<script type="text/javascript">
    function deleteUser(id) {
        const msg = "您确定要删除当前用户吗？（删除用户用户的名片也会被删除哦）";
        if (confirm(msg)) {
            location.href = "DeleteUserServlet?id=" + id;
        } else {
            return false;
        }
    }
</script>