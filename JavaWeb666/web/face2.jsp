<%--
  Created by IntelliJ IDEA.
  User: zyw
  Date: 2021/11/21
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="face.css"/>
    <title>班级通讯录</title>
</head>
<body>
<p id="login" >
<h1>管理员登录</h1>
<form action="/LoginServlet2" method="post" id="from">
    <div style="text-align:center;"><input type="text" required="required" placeholder="管理员ID" name="username"></div>
    <div style="text-align:center;"><input type="password" required="required" placeholder="密码" name="password"></div>
    <a href="face.jsp">切换成用户登录</a>
    <p align="center"><button class="button" type="submit" value="登录">登录</button></p>
</form>
</p>
</body>
</html>
<script>
    var errori ='<%=request.getParameter("error")%>';
    if(errori=='yes'){undefined
        alert("登录失败!管理员id或密码错误~.~");
    }
    var succeed ='<%=request.getParameter("succeed")%>';
    if(succeed=='yes'){undefined
        alert("注册成功！请完成登录！");
    }
</script>
