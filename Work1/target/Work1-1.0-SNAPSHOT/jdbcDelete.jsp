<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
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

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
    PreparedStatement preparedStatement = con.prepareStatement("delete from score where xh=?");
    preparedStatement.setString(1,xh);
    preparedStatement.executeUpdate();

    preparedStatement.close();
    con.close();

    response.sendRedirect("/selectClass.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
