<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/11/8
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/computedServlet" method="post">
    整数1： <input type="text" name="n1"><br>
    整数2： <input type="text" name="n2"><br>
    <input type="submit" value="提交">
</form>
<c:if test="${not empty requestScope.sum}">
    <h3>n1=${requestScope.n1}</h3>
    <h3>n2=${requestScope.n2}</h3>
    <h3>sum=${requestScope.sum}</h3>
    <h3>sub=${requestScope.sub}</h3>
    <h3>div=${requestScope.divv}</h3>
    <h3>mul=${requestScope.mul}</h3>
    <h3>mod=${requestScope.modd}</h3>
</c:if>
</body>
</html>
