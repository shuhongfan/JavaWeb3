<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/14
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #container{
        width: 400px;
        margin: 0 auto;
        text-align: center;
        line-height: 30px;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<div id="container">
    <h1>学生注册</h1>
    <form action="registerMethods" method="post">
        学号： <input type="text" name="id"> <br>
        密码： <input type="text" name="pwd"><br>
        姓名： <input type="text" name="name"><br>
        性别： <input type="text" name="sex"><br>
        出生年月： <input type="date" name="birthday"><br>
        兴趣爱好：
        <input type="checkbox" name="reading" value="读书"> 读书
        <input type="checkbox" name="exercise" value="运动"> 运动
        <input type="checkbox" name="music" value="音乐"> 音乐
        <input type="checkbox" name="art" value="美术"> 美术
        <input type="checkbox" name="travel" value="旅游"> 旅游<br>

        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</div>

</body>
</html>
