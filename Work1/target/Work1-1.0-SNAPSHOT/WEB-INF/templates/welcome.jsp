<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/14
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>您好，
    <%
        String username = (String) session.getAttribute("username");
        if (username==null) request.getRequestDispatcher("/login").forward(request,response);
    %>
    <%=username%>
    欢迎进入我的的网站</h1>
</body>
</html>
