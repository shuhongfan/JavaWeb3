<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/11/16
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="200" cellpadding="0" cellspacing="0">
    <c:forEach items="${list}" varStatus="i" var="item" >
        <tr align="center" class="foreach_tr1">
            <c:forEach items="${item}" varStatus="i" var="itemTd" >
                <td>
                    <h2>${itemTd}</h2>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
