<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="static com.shf.mvc.beans.DbBean.con" %>
<%@ page import="static com.shf.mvc.beans.DbBean.alterUser" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String bh = request.getParameter("bh");
    String xh = request.getParameter("xh");
    String xm = request.getParameter("xm");
    String yw = request.getParameter("yw");
    String sx = request.getParameter("sx");
    String yy = request.getParameter("yy");
    String zf = String.valueOf(Double.parseDouble(yw)+Double.parseDouble(sx)+Double.parseDouble(yy));

    alterUser(Arrays.asList(xm,bh,sx,yy,yw,zf,xh));

    response.sendRedirect("/demo5/selectClass.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
