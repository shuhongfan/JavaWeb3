<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/11/8
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/loginSerVlet" method="post">
    用户名： <input type="text" name="username"> <br>
    密码： <input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
<h1>${info}</h1>
</body>
</html>
