<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/12
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
    int n = 0;
    String counter = (String) application.getAttribute("counter");
    if (counter != null) n = Integer.parseInt(counter);
    if (session.isNew()) ++n;
    counter = String.valueOf(n);
    application.setAttribute("counter", counter);
%>
<h1>您是第
    <%=counter%>
    个访问本站的用户。</h1>
</body>
</html>
