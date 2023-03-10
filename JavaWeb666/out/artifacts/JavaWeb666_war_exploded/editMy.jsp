<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--Created by IntelliJ IDEA.--%>
<%--User: zyw--%>
<%--Date: 2021/11/26--%>
<%--Time: 14:10--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="editMy.css"/>
    <title>查看我的信息</title>
</head>
<body>
<div class="damn">
    <a >Welcome!${Class} ${Name}</a>
    <a href="/ListMyContactServlet" class="find">查看所有联系人</a>
    <a href="/UpdateMyServlet?id=${ID}" class="edit">查看我的信息</a>
    <a href="/OutServlet" class="quit" >退出登录</a></div>
<h3>我的信息</h3>
<form action="EditMyServlet" method="post">
<table align="center" border="1" width="700px">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>QQ</th>
    </tr>

<%--    <c:forEach items="${myInformation}" var="con" varStatus="varSta">--%>
        <tr>
            <td><input type="text" name="name" value="${contact.name}"></td>
            <td><input type="text" name="gender" value="${contact.gender}"></td>
            <td><input type="text" name="age" value="${contact.age}"></td>
            <td><input type="text" name="phone" value="${contact.phone}"></td>
            <td><input type="text" name="email" value="${contact.email}"></td>
            <td><input type="text" name="qq" value="${contact.qq}"></td>

                <%--            <td><a href="${pageContext.request.contextPath }/QueryContactServlet?id=${con.id}">修改</a>&nbsp;<a href="${pageContext.request.contextPath }/DeleteContactServlet?id=${con.id}">删除</a></td>--%>
        </tr>
<%--    </c:forEach>--%>
</table>
<button class="button" type="submit" value="提交">修改</button>
</form>
<a href="editPassword.jsp">修改密码</a>
</body>
</html>
