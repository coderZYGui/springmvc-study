<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 2020/3/6
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <h3>登录界面</h3>
    <form action="/login" method="post">
        账号:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit" value="登录"><br>
    </form>

    <span style="color: red">${errorMsg}</span>
    <!--销毁session-->
    <%
        session.invalidate();
    %>
</body>
</html>
