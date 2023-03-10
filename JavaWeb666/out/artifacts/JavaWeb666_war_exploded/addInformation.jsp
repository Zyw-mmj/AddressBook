<%--
  Created by IntelliJ IDEA.
  User: zyw
  Date: 2021/11/27
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
    <link rel="stylesheet" type="text/css" href="addInformation.css"/>
    <title>添加联系人</title>
</head>

<body>
<div class="damn">
    <a >欢迎管理员！</a>
    <a href="${pageContext.request.contextPath }/addInformation.jsp" class="add">添加用户</a>
    <a href="/ListAllServlet" class="look">查看所有用户</a>
    <a href="/OutServlet" class="quit">退出登录</a></div>
<center><h3>添加联系人</h3></center>
<form action="AddContactServlet" method="post">
    <table align="center" border="1" width="400px" class="eo">
        <tr>
            <th >姓名:</th>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <th>性别:</th>
            <td>
    <div class="zymisagril">
    <label for="man">
    <input name="gender" id="man" type="radio" value="男">
    <span>男</span>
    </label>
    <label for="woman">
    <input checked name="gender" id="woman" type="radio" value="女">
    <span>女</span>
    </label>
    </div>
<%--                <input type="radio" name="gender" value="男"/>男--%>
<%--                <input type="radio" name="gender" value="女"/>女--%>
            </td>
        </tr>
        <tr>
            <th>ID:</th>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <th>班级:</th>
            <td><input type="text" name="class"/></td>
        </tr>
        <tr>
            <th>年龄:</th>
            <td><input type="text" name="age"/></td>
        </tr>
        <tr>
            <th>电话:</th>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <th>邮箱:</th>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <th>QQ:</th>
            <td><input type="text" name="qq"/></td>
        </tr>
        <tr>
            <th>密码:</th>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input class='save' type="submit" value="保存"/>&nbsp;
                <input class='reset' type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
