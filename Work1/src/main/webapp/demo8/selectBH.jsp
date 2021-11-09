<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/11/8
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
班级号： <input type="text" id="bh"> <button id="btn">查询</button><br>
名称: <h4 id="bm"></h4> <br>

<script>
    let btn = document.getElementById("btn")
    btn.onclick=function () {
        var bh = document.getElementById("bh").value
        var bm = document.getElementById("bm")
        var url = "/selectBHByxhServlet?bh="+bh //设置查询字符串
        var xmlhttp;
        if (window.XMLHttpRequest)
        {
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                bm.innerHTML=xmlhttp.responseText
            }
        }
        xmlhttp.open("GET",url,true);
        xmlhttp.send();
    }

</script>
</script>
</body>
</html>
