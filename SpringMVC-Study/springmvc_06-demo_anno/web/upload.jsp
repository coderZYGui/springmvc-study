<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件界面</title>
</head>
<body>
    <h3>上传文件界面</h3>
    <form action="/save"  enctype="multipart/form-data" method="post">
        姓名:<input type="text" name="username"/><br>
        邮箱:<input type="text" name="age"/><br>
        文件:<input type="file" name="pic"/><br>
            <input type="submit" value="提交"/>
    </form>
</body>
</html>
