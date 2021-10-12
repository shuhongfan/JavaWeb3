<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/12
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
<table border="1">
    <tr>
        <td>N</td>
        <td>2*N</td>
        <td>N*N</td>
    </tr>
    <%
        int h=10;
        for(int i=1;i<=h;i++){
    %>
    <tr>
        <td><%=i%></td>
        <td><%=i*2%></td>
        <td><%=i*i%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
