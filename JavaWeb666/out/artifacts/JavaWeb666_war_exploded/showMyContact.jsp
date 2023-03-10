<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: zyw--%>
<%--  Date: 2021/11/26--%>
<%--  Time: 14:10--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="showMyContact.css"/>
    <title>我的联系人</title>
</head>
<body>

<div class="damn">
<a >Welcome!${Class} ${Name}</a>
<a href="/ListMyContactServlet" class="find">查看所有联系人</a>
<a href="/UpdateMyServlet?id=${ID}" class="edit">查看我的信息</a>
    <a href="/OutServlet" class="quit" >退出登录</a></div>
<form action="/FindServlet" method="post">
    姓名：<input type="text" name="name">
    <input type="submit" value="搜索">
</form>
<h3>我的联系人</h3>
    <div class="lam">
<table align="center" border="1" width="700px">
    <tr>
        <th width="60px">编号</th>
        <th width="60px">姓名</th>
        <th width="60px">性别</th>
        <th width="60px">年龄</th>
        <th width="100px">电话</th>
        <th width="100px">邮箱</th>
        <th width="100px">QQ</th>
    </tr>
</table>
        <div style="overflow-y: scroll;height: 300px;">
            <table align="center" border="1" width="700px">
    <c:forEach items="${contacts}" var="con" varStatus="varSta">
        <tr style="height: 30px">
            <td width="60px">${varSta.count}</td>
            <td width="60px">${con.name}</td>
            <td width="60px">${con.gender}</td>
            <td width="60px">${con.age}</td>
            <td width="100px">${con.phone}</td>
            <td width="100px">${con.email}</td>
            <td width="100px">${con.qq}</td>
<%--            <td><a href="${pageContext.request.contextPath }/QueryContactServlet?id=${con.id}">修改</a>&nbsp;<a href="${pageContext.request.contextPath }/DeleteContactServlet?id=${con.id}">删除</a></td>--%>
        </tr>
    </c:forEach>
            </table>
        </div>
    <tr>
<%--        <td colspan="8" align="center"><a href="${pageContext.request.contextPath }/addContact.html">[添加联系人]</a></td>--%>
    </tr>

</table>
    </div>
</body>
    <script>

    </script>

</html>
