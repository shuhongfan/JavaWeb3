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
班级号：
<select name="" id="bh">
    <option value="">---请选择---</option>
</select>
<button id="btn">查询</button><br>
<table id="box" border="1">
    <tr>
        <td>学号</td>
        <td>姓名</td>
    </tr>
</table>
<script>
    window.onload=function () {
        var bh = document.getElementById("bh")
        var url = "/selectBHServlet" //设置查询字符串
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
                console.log(xmlhttp)
                let parse = JSON.parse(xmlhttp.responseText);
                console.log(parse)
                for (let i = 0; i < parse.length; i++) {
                    bh.innerHTML+="<option value='"+parse[i]+"'>"+parse[i]+"</option>"
                }
            }
        }
        xmlhttp.open("GET",url,true);
        xmlhttp.send();

        let btn = document.getElementById("btn");
        btn.onclick=function () {
            var url = "/selectXSByBH?bh="+bh.value //设置查询字符串
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
                    console.log(xmlhttp)
                    let parse = JSON.parse(xmlhttp.responseText);
                    console.log(parse)
                    let box = document.getElementById("box");
                    box.innerHTML="<tr><td>学号</td><td>姓名</td></tr>"
                    let str="";
                    for (let i = 0; i < parse.length; i++) {
                        str+="<tr>"
                        for (let j = 0; j < parse[i].length; j++) {
                            str+="<td>"+parse[i][j]+"</td>"
                        }
                        str+="</tr>"
                    }
                    box.innerHTML+=str
                }
            }
            xmlhttp.open("GET",url,true);
            xmlhttp.send();
        }
    }
</script>
</script>
</body>
</html>
