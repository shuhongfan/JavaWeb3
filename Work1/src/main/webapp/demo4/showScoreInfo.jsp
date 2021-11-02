<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 9:40
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
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <h1>详情</h1>
    <%while (resultSet.next()){%>
    班级: <input type="text" name="bh" disabled value="<%=resultSet.getString("bh")%>"> <br>
    学号: <input type="text" name="xh" disabled value="<%=resultSet.getString("xh")%>"> <br>
    姓名: <input type="text" name="xm" disabled value="<%=resultSet.getString("xm")%>"> <br>
    语文: <input type="text" name="yw" disabled value="<%=resultSet.getString("yw")%>"> <br>
    数学: <input type="text" name="sx" disabled value="<%=resultSet.getString("sx")%>"> <br>
    英语: <input type="text" name="yy" disabled value="<%=resultSet.getString("yy")%>"> <br>
    总分: <input type="text" name="zf" disabled value="<%=resultSet.getString("zf")%>"> <br>
    <%}%>
    <a href="/demo4/selectClass.jsp">返回选择班级页面</a>
</form>
</body>
</html>
