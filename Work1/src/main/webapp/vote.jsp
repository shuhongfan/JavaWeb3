<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/14
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int asp=application.getAttribute("asp")!=null? (int) application.getAttribute("asp") :0;
    int jsp=application.getAttribute("jsp")!=null? (int) application.getAttribute("jsp") :0;
    int php=application.getAttribute("php")!=null? (int) application.getAttribute("php") :0;
    int aspNet=application.getAttribute("aspNet")!=null? (int) application.getAttribute("aspNet") :0;
    application.setAttribute("asp",asp);
    application.setAttribute("jsp",jsp);
    application.setAttribute("php",php);
    application.setAttribute("aspNet",aspNet);

    session.setMaxInactiveInterval(-1);
    if (session.isNew()){
        session.setAttribute("flag","1");
    } else {
        session.setAttribute("flag","0");
    }
%>
<h3>您喜欢哪种Web变成技术？只能投一票喔</h3>
<table border="1">
    <tr>
        <td>ASP</td>
        <td>JSP</td>
        <td>PHP</td>
        <td>ASP.NET</td>
    </tr>
    <tr>
        <td>得票数： <em><%=application.getAttribute("asp")%></em></td>
        <td>得票数： <em><%=application.getAttribute("jsp")%></em></td>
        <td>得票数： <em><%=application.getAttribute("php")%></em></td>
        <td>得票数： <em><%=application.getAttribute("aspNet")%></em></td>
    </tr>
    <tr>
        <td><a href="/voteAdd.jsp?id=asp">投一票</a></td>
        <td><a href="/voteAdd.jsp?id=jsp">投一票</a></td>
        <td><a href="/voteAdd.jsp?id=php">投一票</a></td>
        <td><a href="/voteAdd.jsp?id=aspNet">投一票</a></td>
    </tr>
</table>
<h1 style="color: red"><%=session.getAttribute("notice")==null?"":session.getAttribute("notice")%></h1>
</body>
</html>
