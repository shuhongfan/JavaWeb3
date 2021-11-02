<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="static com.shf.mvc.beans.DbBean.con" %>
<%@ page import="static com.shf.mvc.beans.DbBean.deleteUser" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String xh = request.getParameter("xh");
    System.out.println(xh);

    deleteUser(xh);

    response.sendRedirect("/demo5/selectClass.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
