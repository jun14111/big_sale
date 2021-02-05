<%--
  Created by IntelliJ IDEA.
  User: HuangCJ
  Date: 2021-02-03
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var username = getCookie("username");
            var userid = getCookie("userid");
            // 验证登录
            if (userid == null || username == null) {
                window.location.href = "login.jsp";
            }

            orderList();

        });

        function orderList() {
            id = getCookie("userid")
            $.get("orderInfo/list", {userid: id}, function (result) {
                console.log("listing");
                console.log(result); // 集合
                $("#tb").html(" <tr>\n" +
                    "               <td>商品</td>\n" +
                    "               <td>单价</td>\n" +
                    "               <td>数量</td>\n" +
                    "               <td>金额</td>\n" +
                    "            </tr>");
                $.each(result, function (i, e) {
                    $("#tb").append(`   <tr>
                                            <td>${e.goodsname}</td>
                                            <td>${e.goodsprice}</td>
                                            <td>${e.goodscount}</td>
                                            <td>${e.goodscount * e.goodsprice}</td>
                                        </tr>`)
                });
            }, "json");
        }

        function getCookie(name) {
            var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
            if (arr = document.cookie.match(reg))
                return unescape(arr[2]);
            else
                return null;
        }
    </script>
</head>
<body>
<h1>我的订单</h1>
<a href="killGoodsList.html">返回商品列表</a>
<table id="tb" border="1px" width="600px"></table>

</body>
</html>
