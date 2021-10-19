<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/14
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        if(session.isNew()){
            application.setAttribute("time",new Date());
    %>

    <h1>欢迎新用户登录</h1>
    <h3>现在的时间为：<%=new Date()%></h3>
    <%
    }else{
    %>

    <h1>欢迎老顾客！</h1>
    <h3>现在的时间为：<%=new Date()%></h3>
    <h3>你上次访问的时间为：<%=application.getAttribute("time")%></h3>

    <%
        }
    %>
</body>
</html>
