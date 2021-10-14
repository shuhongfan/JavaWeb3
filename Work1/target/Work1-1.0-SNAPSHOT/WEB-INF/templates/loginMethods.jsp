<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/14
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("abc")&&password.equals("123")){
            request.getRequestDispatcher("/welcome").forward(request,response);
            session.setAttribute("username",username);
        } else {
            request.getRequestDispatcher("/error").forward(request,response);
        }
    %>
</body>
</html>