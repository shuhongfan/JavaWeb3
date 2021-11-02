<%@ page import="java.sql.*" %>
<%@ page import="static com.shf.mvc.beans.DbBean.con" %>
<%@ page import="static com.shf.mvc.beans.DbBean.countUser" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="static com.shf.mvc.beans.DbBean.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/10/19
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String bh = request.getParameter("bh");
    int getPage = request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):0;
    System.out.println(bh);
    System.out.println(getPage);

    Integer count = countUser(bh);

    int pageSize=2;
    int currentPage=1;
    int pageNumber=count%pageSize==0?count/pageSize:count/pageSize+1;
    if (getPage == 0) currentPage=1;
    else if (getPage<=1) currentPage=1;
    else if (getPage>=pageNumber) currentPage=pageNumber;
    else currentPage=getPage;

    int sql=(currentPage-1)*pageSize;
    System.out.println(sql);
    List<List<String>> lists = showUserInfoPages(Arrays.asList(bh, String.valueOf(sql), String.valueOf(pageSize)));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <h2>学生成绩</h2>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>班级</td>
            <td>总分</td>
            <td>详情</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <%
            for (List<String> list : lists) {
        %>
        <tr>
            <td><em><%=list.get(0)%></em></td>
            <td><em><%=list.get(1)%></em></td>
            <td><em><%=list.get(2)%></em></td>
            <td><em><%=list.get(3)%></em></td>
            <td><em><a href="/demo5/showScoreInfo.jsp?xh=<%=list.get(0)%>">详情</a></em></td>
            <td><em><a href="/demo5/jdbcAlter.jsp?xh=<%=list.get(0)%>">修改</a></em></td>
            <td><em><a href="/demo5/jdbcDelete.jsp?xh=<%=list.get(0)%>">删除</a></em></td>
        </tr>
        <%}%>
        <p>
            <span>第 <%=currentPage%> 页， 共 <%=pageNumber%> 页</span>
            <a href="/demo5/showScore.jsp?bh=<%=bh%>">首页</a>
            <% if(currentPage!=1){%>
                <a href="/demo5/showScore.jsp?bh=<%=bh%>&page=<%=currentPage-1%>">上一页</a>
            <%}%>
            <% if(currentPage!=pageNumber){%>
                <a href="/demo5/showScore.jsp?bh=<%=bh%>&page=<%=currentPage+1%>">下一页</a>
            <%}%>
            <input type="text" placeholder="跳转到第 N 页" id="N">
            <a href="javascript:;" onclick="toShowScore(<%=bh%>)">跳转</a>
        </p>
    </table>
    <script>
        function toShowScore(bh) {
            var N = document.getElementById('N').value;
            window.location.href="/demo5/showScore.jsp?bh="+bh+"&page="+N
        }
    </script>
</body>
</html>
