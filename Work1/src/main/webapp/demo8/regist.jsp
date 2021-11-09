<%--
  Created by IntelliJ IDEA.
  User: SHF
  Date: 2021/11/9
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户注册</h1>
用户名： <input type="text" id="username"> <span style="color: red; font-size: 30px" id="info"></span><br>
密码： <input type="text" id="pwd"> <br>
<button id="btn">注册</button>
<script>
    let flag = true
    let btn = document.getElementById("btn")
    let username = document.getElementById("username")
    let pwd = document.getElementById("pwd")
    let info = document.getElementById("info")
    username.onblur=function () {
        var url = "/isValidUsernameServlet?username="+username.value //设置查询字符串
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
                    info.innerHTML="用户名不可用"
                    flag=false
                } else{
                    info.innerHTML="用户名可用"
                    flag=true
                }
            }
        }
        xmlhttp.open("POST",url,true);
        xmlhttp.send();
    }

    btn.onclick=function () {
        if (flag==false){
            alert("用户名不可用，请重新输入！！！");
            return;
        }
        var url = "/addUsernameServlet?username="+username.value+"&pwd="+pwd.value //设置查询字符串
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
                    info.innerHTML="注册失败"
                    location.href="/demo8/error.jsp"
                } else{
                    info.innerHTML="注册成功"
                    location.href="/demo8/success.jsp"
                }
            }
        }
        xmlhttp.open("GET",url,true);
        xmlhttp.send();
    }
</script>
</body>
</html>
