<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 2020/3/6
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <span>恭喜${user_in_session.username}:登录成功</span>
    <span style="color: blue"><a href="/login">注销</a></span>
    <h3>员工列表</h3>
    <!--跳转到Controller的input-->
    <a href="/employee/input">新增</a>
    <table border="1" cellpadding="0" cellspacing="0" width="500">
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>入职时期</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${employees}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.username}</td>
                <td>${e.password}</td>
                <td>${e.hiredate}</td>
                <td>
                    <a href="/employee/delete?id=${e.id}">删除</a>
                    <a href="/employee/input?id=${e.id}">编辑</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
