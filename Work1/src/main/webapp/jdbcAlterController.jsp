<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %><%--
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

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");

    PreparedStatement preparedStatement = con.prepareStatement("update score set xm=?,bh=?,sx=?,yy=?,yw=?,zf=? where xh=?");

    preparedStatement.setString(1, xm);
    preparedStatement.setString(2, bh);
    preparedStatement.setString(3, sx);
    preparedStatement.setString(4, yy);
    preparedStatement.setString(5, yw);
    preparedStatement.setString(6, zf);
    preparedStatement.setString(7, xh);
    System.out.println(preparedStatement);

    preparedStatement.executeUpdate();

    //8、释放资源
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
