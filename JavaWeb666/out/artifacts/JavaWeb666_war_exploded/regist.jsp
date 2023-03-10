<%--
  Created by IntelliJ IDEA.
  User: zyw
  Date: 2021/11/26
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册信息</title>
    <link rel="stylesheet" type="text/css" href="regist.css"/>
</head>
<body>
<h3>填写信息，注册账号</h3>
<div class="silizhang" >
<form action="RegistServlet" method="post" onsubmit="return checkAll()">
    <div class="zyw" style="text-align:center;"><input type="text" required="required" placeholder="姓名" name="name" id="name" onblur="checkName()"><a href="#" id="nameclass" class=""> </a><div class="clear"></div></li>&nbsp;&nbsp;<span  style="font-size:13px" id="namespan"></span></div>
    <div class="zyw2" style="text-align:center;width:200px;"><input type="text" required="required" placeholder="用户名/学号" name="userID"></div>
    <div class="zyw3" style="text-align:center;"><input type="password" required="required" placeholder="密码" name="password" id="password"onblur="checkPassword()"><a href="#" id="passwordclass" class=""> </a>
        <div class="clear"></div></li>&nbsp;&nbsp;<span  style="font-size:10px" id="passwordspan"></span></div>
    <div class="zywsabe" style="text-align:center;"><input type="password" required="required" placeholder="确认密码" name="password2`" id="password2"onblur="checkSame()"><a href="#" id="passwordclass2" class=""> </a>
        <div class="clear"></div></li>&nbsp;&nbsp;<span  style="font-size:10px" id="passwordspan2"></span></div>
    <div class="zymisagril">
    <span><em style="color: red">*</em>性别: &nbsp;&nbsp;</span>
    <label for="man">
    <input name="gender" id="man" type="radio" value="男">
    <span>男</span>
    </label>
    <label for="woman">
    <input checked name="gender" id="woman" type="radio" value="女">
    <span>女</span>
    </label>
    </div>
<%--    --%>
<%--    <div class="zyw4" style="text-align:center;">--%>
<%--    <div class="man" style="text-align:center;">--%>
<%--    <input type="radio" name="gender" value="男"/>男</div>--%>
<%--    <div class="woman" style="text-align:center;">--%>
<%--    <input type="radio" name="gender" value="女"/>女</div></div>--%>


    <div class="zyw5"style="text-align:center;"><input type="text" required="required" placeholder="班级" name="Class"></div>
    <div class="zyw6"style="text-align:center;"><input type="text" required="required" placeholder="电话号码" name="phone"></div>
    <p align="center"><button class="button" type="submit" value="注册">注册</button></p>
    </div>
    </form>
</body>
</html>
<script>
    //取出传回来的参数error并与yes比较
    var errori ='<%=request.getParameter("error")%>';
    if(errori=='yes'){undefined
        alert("注册失败！用户命已存在！");
    }
    function checkName(){
        var name = document.getElementById("name").value;
        var spanNode = document.getElementById("namespan");
        //用户名的规则： 昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号
        var reg = /^([\u4e00-\u9fa5]|[a-zA-Z0-9]){1,15}$/i;
        if(reg.test(name)){
            //符合规则
            spanNode.innerHTML = "".fontcolor("green");
            document.getElementById("nameclass").className = "icon ticker";
            return true;
        }else{
            //不符合规则
            spanNode.innerHTML = "昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号".fontcolor("red");
            document.getElementById("nameclass").className = "icon into";
            return false;
        }
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
        var name = checkName();
        // var id = checkId();
        var password = checkPassword();
        var same = checkSame();
        if(name&&password&&same){
            return true;
        }else{
            return false;
        }

    }

</script>
