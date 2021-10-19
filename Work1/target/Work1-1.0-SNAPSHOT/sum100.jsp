<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/12
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int count = Integer.parseInt(request.getParameter("sum"));
    int sum = 0;
    for (int i = 1; i < count; i++) {
         sum+=i;
    }
%>
<h1>1-<%=count%>的整数和为：<%=sum%></h1>
</body>
</html>
