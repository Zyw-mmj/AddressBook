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
<div class="damn">
    <a >欢迎管理员！</a>
    <a href="${pageContext.request.contextPath }/addInformation.jsp" class="add">添加用户</a>
    <a href="/ListAllServlet" class="look">查看所有用户</a>
    <a href="/OutServlet" class="quit">退出登录</a></div>
<center><h3>所有用户信息</h3></center>
<form action="/FindServlet2" method="post">
    姓名：<input type="text" name="name">
    <input type="submit" value="搜索">
</form>
<form action="/DeleteSomeServlet" method="post">
    <table align="center" border="1" width="1000px">

        <tr>
            <th width="40px">编号</th>
            <th width="50px">姓名</th>
            <th width="40px">性别</th>
            <th width="100px">ID</th>
            <th width="100px">班级</th>
            <th width="40px">年龄</th>
            <th width="100px">电话</th>
            <th width="100px">邮箱</th>
            <th width="100px">QQ</th>
            <%--        <th>密码</th>--%>
            <th width="60px">操作</th>
            <th width="60px"><input class="la" type="submit" value="删除"></th>
        </tr>
    </table>
        <div style="overflow-y: scroll;height: 400px">
            <table align="center" border="1" width="1000px">
        <c:forEach items="${contacts}" var="con" varStatus="varSta">
            <tr>
                <td width="40px">${varSta.count }</td>
                <td width="50px">${con.name }</td>
                <td width="40px">${con.gender }</td>
                <td width="100px">${con.id }</td>
                <td width="100px">${con.classes }</td>
                <td width="40px">${con.age }</td>
                <td width="100px">${con.phone}</td>
                <td width="100px">${con.email}</td>
                <td width="100px">${con.qq }</td>
                    <%--            <td>${con.password }</td>--%>
                <td width="60px"><a href="${pageContext.request.contextPath }/QueryContactServlet?id=${con.id}">修改</a>&nbsp;</td>
                <td width="60px"><label><input type="checkbox" value="${con.id}" name="delete"></label></td>
            </tr>
        </c:forEach>

    </table>
        </div>
<%--    <tr>--%>
<%--        <td colspan="11" align="center"><a href="${pageContext.request.contextPath }/addInformation.jsp">[添加用户]</a></td>--%>
<%--    </tr>--%>
</form>
</body>
</html>

