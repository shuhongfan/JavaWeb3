<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/14
  Time: 9:42
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
    String flag = (String) session.getAttribute("flag");

    if (flag=="1") {
        String id = (String) request.getParameter("id");
        System.out.println(id);
        if ("asp".equals(id)) asp++;
        if ("jsp".equals(id)) jsp++;
        if ("php".equals(id)) php++;
        if ("aspNet".equals(id)) aspNet++;
    } else {
        session.setAttribute("notice","只能投一票喔");
    }

    application.setAttribute("asp",asp);
    application.setAttribute("jsp",jsp);
    application.setAttribute("php",php);
    application.setAttribute("aspNet",aspNet);

    response.sendRedirect("/vote.jsp");
%>
</body>
</html>
