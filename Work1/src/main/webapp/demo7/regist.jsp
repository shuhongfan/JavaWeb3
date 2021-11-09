<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/11/8
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty username}">
<form action="/registerServlet" method="post">
    用户昵称： <input type="text" name="username"> <br>
    密码： <input type="text" name="password"> <br>
    确认密码： <input type="text" name="rpassword"> <br>
    性别： <input type="radio" name="gender" value="1"> 男
        <input type="radio" name="gender" value="0"> 女 <br>
    爱好： <input type="checkbox" name="hobby" value="体育"> 体育
        <input type="checkbox" name="hobby" value="美术"> 美术
        <input type="checkbox" name="hobby" value="音乐"> 音乐
        <input type="checkbox" name="hobby" value="旅游"> 旅游 <br>
    <input type="submit" value="提交">
</form>
</c:if>

<c:if test="${not empty username}">
    <h3>username=${username}</h3>
    <h3>password=${password}</h3>
    <h3>gender=${gender==1?"男":"女"}</h3>
    <h3>
        hobby=
        <c:forEach var="val" items="${hobby}">
            <span>${val}</span>
        </c:forEach>
    </h3>
</c:if>

</body>
</html>
