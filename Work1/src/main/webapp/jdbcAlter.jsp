<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String xh = request.getParameter("xh");
    System.out.println(xh);
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
    PreparedStatement preparedStatement = con.prepareStatement("select * from score where xh=?");
    preparedStatement.setString(1,xh);
    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="jdbcAlterController.jsp">
    <h2>学生成绩</h2>
    班级: <input type="text" name="bh" value="<%=resultSet.getString("bh")%>"> <br>
    学号: <input type="text" name="xh" value="<%=resultSet.getString("xh")%>" readonly> <br>
    姓名: <input type="text" name="xm" value="<%=resultSet.getString("xm")%>"> <br>
    语文: <input type="text" name="yw" value="<%=resultSet.getString("yw")%>"> <br>
    数学: <input type="text" name="sx" value="<%=resultSet.getString("sx")%>"> <br>
    英语: <input type="text" name="yy" value="<%=resultSet.getString("yy")%>"> <br>
    总分: <input type="text" name="zf" value="<%=resultSet.getString("zf")%>" readonly> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
