<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="static com.shf.mvc.beans.DbBean.addUser" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String bh = request.getParameter("bh");
    String xh = request.getParameter("xh");
    String xm = request.getParameter("xm");
    String yw = request.getParameter("yw");
    String sx = request.getParameter("sx");
    String yy = request.getParameter("yy");
    String zf = String.valueOf(Double.parseDouble(yw)+Double.parseDouble(sx)+Double.parseDouble(yy));

    addUser(Arrays.asList(xh,xm,bh,sx,yy,yw,zf));

    response.sendRedirect("/demo5/selectClass.jsp");
%>
</body>
</html>
