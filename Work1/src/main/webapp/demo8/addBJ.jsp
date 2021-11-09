<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/11/9
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
班级编号： <input type="text" id="bjbn" value="" name="bjbn"> <span id="info" style="font-size: 30px;color: red"></span><br>
班级名称： <input type="text" id="bjmc" value="" name="bjmc"> <br>
<button id="btn">添加班级</button>
<script>
    let flag = true
    let btn = document.getElementById("btn")
    let bjbn = document.getElementById("bjbn")
    let bjmc = document.getElementById("bjmc")
    let info = document.getElementById("info")
    bjbn.onblur=function () {
        var url = "/isValidBJServlet?bh="+bjbn.value //设置查询字符串
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
                if (xmlhttp.responseText=="false"){
                    info.innerHTML="班级号不可用"
                    flag=false
                } else{
                    info.innerHTML="班级号可用"
                    flag=true
                }
            }
        }
        xmlhttp.open("POST",url,true);
        xmlhttp.send();
    }

    btn.onclick=function () {
        if (flag==false){
            alert("班级编号不可用，请重新输入！！！");
            return;
        }
        var url = "/addBjServlet?bjbn="+bjbn.value+"&bjmc="+bjmc.value //设置查询字符串
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
                if (xmlhttp.responseText=="false"){
                    info.innerHTML="添加失败"
                } else{
                    info.innerHTML="添加成功"
                }
            }
        }
        xmlhttp.open("GET",url,true);
        xmlhttp.send();
    }
</script>
</body>
</html>
