<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/11/9
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传结果</title>
</head>
<body>
<center>
    <h2>${message}</h2>
    <a href="/exportExcelServlet?filename=${filename}">显示JSP页面</a>
</center>
</body>
</html>