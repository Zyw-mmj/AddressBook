<%--
  Created by IntelliJ IDEA.
  User: zyw
  Date: 2022/1/24
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="editPassword.css"/>
    <title>修改密码</title>
</head>
<body>
<div class="damn">
    <a >Welcome!${Class} ${Name}</a>
    <a href="/ListMyContactServlet" class="find">查看所有联系人</a>
    <a href="/UpdateMyServlet?id=${ID}" class="edit">查看我的信息</a>
    <a href="/OutServlet" class="quit" >退出登录</a></div>
<h3>修改密码</h3>
<form action="/EditPasswordServlet" method="post">
    <div style="height: 59.6px">用户账号 :<input type="text" required="required" name="theID"></div>
    <div style="text-align: center;height: 59.6px">旧的密码 :<input type="password" required="required" name="oldPwd"></div>
    <div  style="text-align:center;">新的密码 :<input type="password" required="required"  name="newPwd" id="password"onblur="checkPassword()"><a href="#" id="passwordclass" class=""> </a>
        <div class="clear"></div></li>&nbsp;&nbsp;<span  style="font-size:10px" id="passwordspan"></span></div>
    <div class="zywsabe" style="text-align:center;"> 确认密码 :<input type="password" required="required" name="password2`" id="password2"onblur="checkSame()"><a href="#" id="passwordclass2" class=""> </a>
        <div class="clear"></div></li>&nbsp;&nbsp;<span  style="font-size:10px" id="passwordspan2"></span></div>
    <button class="button" type="submit" value="确定修改">确定修改</button>
</form>
</body>
</html>
<script>
    var errori ='<%=request.getParameter("error")%>';
    if(errori=='yes'){undefined
        alert("修改失败！用户名或密码错误！");
    }
    function checkPassword(){
        var password = document.getElementById("password").value;
        var spanNode = document.getElementById("passwordspan");
        //密码的规则： 6-16，包含任意的字母、数字，不可以使用其他符号
        var reg = /^([a-zA-Z0-9]){6,16}$/i;
        if(reg.test(password)){
            //符合规则
            spanNode.innerHTML = "".fontcolor("green");
            document.getElementById("passwordclass").className = "icon ticker";
            return true;
        }else{
            //不符合规则
            spanNode.innerHTML = "密码的长度为 6-16，包含任意的字母、数字，不可以使用其他符号".fontcolor("red");
            document.getElementById("passwordclass").className = "icon into";
            return false;
        }
    }
    function checkSame(){
        var password = document.getElementById("password").value;
        var password2 = document.getElementById("password2").value;
        var spanNode = document.getElementById("passwordspan2");
        //密码的规则： 6-16，包含任意的字母、数字，不可以使用其他符号
        var reg = /^([a-zA-Z0-9]){6,16}$/i;
        //确认密码输入符合规则
        if(reg.test(password2)){
            //符合规则
            if(password==password2){undefined
                spanNode.innerHTML = "".fontcolor("green");
                document.getElementById("passwordclass2").className = "icon ticker";
                return true;
            }else{undefined
                spanNode.innerHTML = "两次输入的密码不一致！".fontcolor("red");
                document.getElementById("passwordclass2").className = "icon into";
                return false;
            }
        }
        //确认输入密码不符合规则
        else{
            spanNode.innerHTML = "密码的长度为 6-16，包含任意的字母、数字，不可以使用其他符号".fontcolor("red");
            document.getElementById("passwordclass2").className = "icon into";
            return false;
        }
    }
    function checkAll(){
        // var email = checkEmail();
        var password = checkPassword();
        var same = checkSame();
        if(name&&password&&same){
            return true;
        }else{
            return false;
        }

    }
</script>