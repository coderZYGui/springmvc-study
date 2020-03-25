<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        pageContext.setAttribute("myDate", new java.util.Date());
    %>

    北京时间: <fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd HH:mm:ss"/>


</body>
</html>
