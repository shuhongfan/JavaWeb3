<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/18
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
</head>
<body>
<h2>学生成绩增加</h2>
<form action="/jdbc/addUser" method="post">
    班级：
    <select name="bj" id="">
        <option value=""></option>
    </select> <br>
    学号： <input type="text" name="xh"> <br>
    姓名： <input type="text" name="xm"> <br>
    语文： <input type="text" name="yw"> <br>
    数学： <input type="text" name="sx"> <br>
    英语： <input type="text" name="yy"> <br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
