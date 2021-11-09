<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/11/8
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>您好! <%=request.getSession().getAttribute("username")%>!  欢迎进入我们的网站！！！</h1>
<a href="/demo6/protect/addUser.jsp">添加用户</a>
<h1><%=request.getParameter("xm")==null?"":request.getParameter("xm")+" 添加成功！！！"%> </h1>
</body>
</html>
