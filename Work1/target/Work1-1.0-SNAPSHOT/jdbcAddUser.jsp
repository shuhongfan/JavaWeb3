<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.PreparedStatement" %><%--
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

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");

    PreparedStatement preparedStatement = con.prepareStatement("insert into score values (?,?,?,?,?,?,?)");

    preparedStatement.setString(1, xh);
    preparedStatement.setString(2, xm);
    preparedStatement.setString(3, bh);
    preparedStatement.setString(4, sx);
    preparedStatement.setString(5, yy);
    preparedStatement.setString(6, yw);
    preparedStatement.setString(7, zf);
    preparedStatement.executeUpdate();

    //8、释放资源
    preparedStatement.close();
    con.close();

    response.sendRedirect("/selectClass.jsp");
%>
</body>
</html>
