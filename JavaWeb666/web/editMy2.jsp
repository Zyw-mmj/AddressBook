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
    <title>编辑我的信息</title>
</head>
<body>
<%--<h3>我的信息</h3>--%>
<%--<table align="center" border="1" width="700px">--%>
<%--    <tr>--%>

<%--        <th>姓名</th>--%>
<%--        <th>性别</th>--%>
<%--        <th>年龄</th>--%>
<%--        <th>电话</th>--%>
<%--        <th>邮箱</th>--%>
<%--        <th>QQ</th>--%>
<%--    </tr>--%>

<%--    <c:forEach items="${myInformation}" var="con" varStatus="varSta">--%>
<%--        <tr>--%>

<%--            <td>${con.name}</td>--%>
<%--            <td>${con.gender}</td>--%>
<%--            <td>${con.age}</td>--%>
<%--            <td>${con.phone}</td>--%>
<%--            <td>${con.email}</td>--%>
<%--            <td>${con.qq}</td>--%>
<%--                &lt;%&ndash;            <td><a href="${pageContext.request.contextPath }/QueryContactServlet?id=${con.id}">修改</a>&nbsp;<a href="${pageContext.request.contextPath }/DeleteContactServlet?id=${con.id}">删除</a></td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>

<h3>修改我的信息</h3>
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

            <c:forEach items="${theInformation}" var="con" varStatus="varSta">
                <tr>

                    <td>${con.name}</td>
                    <td>${con.gender}</td>
                    <td>${con.age}</td>
                    <td>${con.phone}</td>
                    <td>${con.email}</td>
                    <td>${con.qq}</td>
                        <%--            <td><a href="${pageContext.request.contextPath }/QueryContactServlet?id=${con.id}">修改</a>&nbsp;<a href="${pageContext.request.contextPath }/DeleteContactServlet?id=${con.id}">删除</a></td>--%>
                </tr>
            </c:forEach>
<%--        </table>--%>
<%--            </c:forEach>--%>
    </table>
    <button class="button" type="submit" value="提交">提交</button>
</form>
</body>
</html>
