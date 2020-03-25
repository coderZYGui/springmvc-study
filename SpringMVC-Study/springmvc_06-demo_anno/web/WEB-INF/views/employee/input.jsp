<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>

<body>

    <!--使用SpringMVC的表单标签-->

    <!--默认请求就是POST-->
	<h3>编辑员工</h3>
    <form:form action="/employee/saveOrUpdate" modelAttribute="employee">
        <form:hidden path="id"/><br>
        账号:<form:input path="username"/>							<form:errors path="username" cssStyle="color: red"/><br>
        密码:<form:password path="password" showPassword="true"/> 	<form:errors path="password"
																				cssStyle="color: red"/> <br>
        年龄:<form:input path="age"/>								<form:errors path="age" cssStyle="color: red"/> <br>
        入职:<form:input path="hiredate"/><br>
        <input type="submit" value="保存"><br>
    </form:form>


    <hr>

<%--	<c:forEach items="${errors}" var="error">
		<div style="color: red">${error.defaultMessage}</div>
	</c:forEach>
	<h3>编辑员工</h3>
	<form action="/employee/saveOrUpdate" method="post">
		<input type="hidden" name="id" value="${employee.id}">
		账号:<input type="text" name="username" value="${employee.username}"><br>
		密码:<input type="password" name="password" value="${employee.password}"><br>
		年龄:<input type="text" name="age" value="${employee.age}"><br>
		入职:<input type="text" name="hiredate" value="${employee.hiredate}"><br>
		<input type="submit" value="保存">
	</form>--%>

</body>
</html>