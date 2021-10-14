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
<%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String birthday = request.getParameter("birthday");
    String reading = request.getParameter("reading");
    String exercise = request.getParameter("exercise");
    String music = request.getParameter("music");
    String art = request.getParameter("art");
    String travel = request.getParameter("travel");
%>
<div id="container">
    <h1>注册信息</h1>
    <form>
        学号： <input type="text" name="id" value="<%=id%>"> <br>
        密码： <input type="text" name="pwd" value="<%=pwd%>"><br>
        姓名： <input type="text" name="name" value="<%=name%>"><br>
        性别： <input type="text" name="sex" value="<%=sex%>"><br>
        出生年月： <input type="date" name="birthday" value="<%=birthday%>"><br>
        兴趣爱好: <textarea rows="10">
                <%=reading!=null?reading:""%>
                <%=exercise!=null?exercise:""%>
                <%=music!=null?music:""%>
                <%=art!=null?art:""%>
                <%=travel!=null?travel:""%>
            </textarea>
    </form>
</div>

</body>
</html>
