<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zyw
  Date: 2021/11/27
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="listInformation.css"/>
</head>
<body>
<div class="lisunjian">欢迎！ 管理员   <a href="/OutServlet" class='lis'>退出登录</a>
</div>
<center><h3>所有用户信息</h3></center>
<form action="/FindServlet2" method="post">
    姓名：<input type="text" name="name">
    <input type="submit" value="搜索">
</form>
<form action="/DeleteSomeServlet" method="post">

    <table align="center" border="1" width="1000px">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>ID</th>
            <th>班级</th>
            <th>年龄</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>QQ</th>
            <%--        <th>密码</th>--%>
            <th>操作</th>
            <th><input class="la" type="submit" value="删除"></th>
        </tr>
        <c:forEach items="${theInformation}" var="con" varStatus="varSta">
            <tr>
                <td>${varSta.count }</td>
                <td>${con.name }</td>
                <td>${con.gender }</td>
                <td>${con.id }</td>
                <td>${con.classes }</td>
                <td>${con.age }</td>
                <td>${con.phone}</td>
                <td>${con.email}</td>
                <td>${con.qq }</td>
                    <%--            <td>${con.password }</td>--%>
                <td><a href="${pageContext.request.contextPath }/QueryContactServlet?id=${con.id}">修改</a>&nbsp;</td>
                <td><label><input type="checkbox" value="${con.id}" name="delete"></label></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="11" align="center"><a href="${pageContext.request.contextPath }/addInformation.jsp">[添加用户]</a></td>
        </tr>
    </table>
</form>
</body>
</html>
