<%--
  Created by IntelliJ IDEA.
  User: HuangCJ
  Date: 2021-02-03
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <script src="js/jquery-3.5.1.min.js"></script>

    <script type="text/javascript">
        function login() {
            var parm = {
                username: $("#username").val(),
                password: $("#password").val()
            }
            $.get("userinfo/loginGetPk", parm, function (id) {
                console.log(id);
                // 正确
                if (id != null) {
                    // 用户名存入cookie
                    SetCookie("username", $("#username").val());
                    SetCookie("userid", id)

                    // 跳转 killGoodsList.html
                    window.location.href = "killGoodsList.html";
                }
                // 错误
                else {
                    alert("用户名或密码错误");
                }
            }, "json");
        }

        function SetCookie(name, value, days) {
            var finalDays = 7; //cookie存储时间默认7天
            if (typeof (days) != "undefined" && !isNaN(days)) {
                finalDays = parseInt(days);
            }
            var exp = new Date();
            exp.setTime(exp.getTime() + finalDays * 24 * 60 * 60 * 1000);
            document.cookie = name + "=" + escape(value) + ";path=/ ;expires=" + exp.toGMTString();
        }
    </script>
</head>
<body>
<h1>用户登录</h1>

<form method="post">
    用户名：<input type="text" name="username" id="username"><br>
    密码：<input type="password" name="password" id="password"><br>
    <input type="button" value="登录" onclick="login()"><br>
</form>

</body>
</html>
