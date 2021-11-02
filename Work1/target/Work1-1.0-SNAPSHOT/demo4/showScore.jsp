<%@ page import="java.sql.*" %><%--
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

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
    PreparedStatement countSql = con.prepareStatement("select count(*) cou from score where bh=?");
    countSql.setString(1,bh);
    ResultSet countN = countSql.executeQuery();
    countN.next();
    String cou = countN.getString("cou");
    int count= Integer.parseInt(cou);

    int pageSize=2;
    int currentPage=1;
    int pageNumber=count%pageSize==0?count/pageSize:count/pageSize+1;
    if (getPage == 0) currentPage=1;
    else if (getPage<=1) currentPage=1;
    else if (getPage>=pageNumber) currentPage=pageNumber;
    else currentPage=getPage;

    int sql=(currentPage-1)*pageSize;
    System.out.println(sql);

    PreparedStatement preparedStatement = con.prepareStatement("select * from score where bh=? limit ?,? ");
    preparedStatement.setString(1,bh);
    preparedStatement.setInt(2, sql);
    preparedStatement.setInt(3, pageSize);
    ResultSet resultSet = preparedStatement.executeQuery();
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
        <%while (resultSet.next()){%>
        <tr>
            <td><em><%=resultSet.getString("xh")%></em></td>
            <td><em><%=resultSet.getString("xm")%></em></td>
            <td><em><%=resultSet.getString("bh")%></em></td>
            <td><em><%=resultSet.getString("zf")%></em></td>
            <td><em><a href="/demo4/showScoreInfo.jsp?xh=<%=resultSet.getString("xh")%>">详情</a></em></td>
            <td><em><a href="/demo4/jdbcAlter.jsp?xh=<%=resultSet.getString("xh")%>">修改</a></em></td>
            <td><em><a href="/demo4/jdbcDelete.jsp?xh=<%=resultSet.getString("xh")%>">删除</a></em></td>
        </tr>
        <%}%>
        <p>
            <span>第 <%=currentPage%> 页， 共 <%=pageNumber%> 页</span>
            <a href="/demo4/showScore.jsp?bh=<%=bh%>">首页</a>
            <% if(currentPage!=1){%>
                <a href="/demo4/showScore.jsp?bh=<%=bh%>&page=<%=currentPage-1%>">上一页</a>
            <%}%>
            <% if(currentPage!=pageNumber){%>
                <a href="/demo4/showScore.jsp?bh=<%=bh%>&page=<%=currentPage+1%>">下一页</a>
            <%}%>
            <input type="text" placeholder="跳转到第 N 页" id="N">
            <a href="javascript:;" onclick="toShowScore(<%=bh%>)">跳转</a>
        </p>

        <%
            countSql.close();
            preparedStatement.close();
            con.close();
        %>
    </table>
    <script>
        function toShowScore(bh) {
            var N = document.getElementById('N').value;
            window.location.href="/demo4/showScore.jsp?bh="+bh+"&page="+N
        }

    </script>
</body>
</html>
