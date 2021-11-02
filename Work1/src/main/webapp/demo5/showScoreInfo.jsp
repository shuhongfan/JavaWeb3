<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="static com.shf.mvc.beans.DbBean.con" %>
<%@ page import="static com.shf.mvc.beans.DbBean.showUserInfo" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %><%--
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

    List<String> pars = showUserInfo(Arrays.asList(xh));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <h1>详情</h1>
    班级: <input type="text" name="bh" disabled value="<%=pars.get(0)%>"> <br>
    学号: <input type="text" name="xh" disabled value="<%=pars.get(1)%>"> <br>
    姓名: <input type="text" name="xm" disabled value="<%=pars.get(2)%>"> <br>
    语文: <input type="text" name="yw" disabled value="<%=pars.get(3)%>"> <br>
    数学: <input type="text" name="sx" disabled value="<%=pars.get(4)%>"> <br>
    英语: <input type="text" name="yy" disabled value="<%=pars.get(5)%>"> <br>
    总分: <input type="text" name="zf" disabled value="<%=pars.get(6)%>"> <br>
    <a href="/demo5/selectClass.jsp">返回选择班级页面</a>
</form>
</body>
</html>
