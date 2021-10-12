<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/12
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sum</title>
</head>
<body>
<%
    int sum = 0;
    for (int i = 1; i < 100; i++) {
        if (i%3==0) sum+=i;
    }
%>
<h1>1-100内可以被3整除的整数和为：<%=sum%></h1>
</body>
</html>
