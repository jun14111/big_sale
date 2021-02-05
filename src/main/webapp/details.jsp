<%--
  Created by IntelliJ IDEA.
  User: HuangCJ
  Date: 2021-02-03
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>商品详情</title>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.get("killGoods/selectOneByPk", {killid:${param.killid}}, function (result) {
                console.log("selectOneByPk");
                console.log(result);
                // 商品名
                $("#goodsName").html(result.goodsContent);
                // 图片
                $("#goodsImg").html("<img src='" + result.goodsImg + "' width='80px' height='80px' alt='img'>");
                // 时间
                current = currentState(result.startdate, result.enddate);
                if (current == 1) {
                    $("#state").html("秒杀时间：未开始")
                } else if (current == 2) {
                    $("#state").html("秒杀时间：进行中")
                } else if (current == 3) {
                    $("#state").html("秒杀时间：已结束")
                }
                // 库存
                $("#stockcount").html("库存: " + result.stockcount);
            }, "json");
        });

        function currentState(begin, end) {
            /**1-未开始
             * 2-进行中
             * 3-已结束
             */
            var currentTimg = new Date;
            var beginTimg = new Date(begin);
            var endTimg = new Date(end);
            if (currentTimg < beginTimg) {
                return 1;
            } else if (beginTimg <= currentTimg && currentTimg <= endTimg) {
                return 2;
            } else {
                return 3;
            }
        }

        function buy() {
            // 检查条件-开始
            // 验证登录
            var username = getCookie("username");
            var userid = getCookie("userid");
            if (userid == null || username == null) {
                window.location.href = "login.jsp";
            }
            // 验证数量
            if ($("#buyNum").val() > 1) {
                alert("用户一次只能买一件商品");
                return;
            }

            id = getCookie("userid")
            $.get("buy/check", {killid:${param.killid}, goodsid:${param.goodsid}, userid: id}, function (result) {
                if (result == 1) {
                    alert("商品库存为0");
                } else if (result == 2) {
                    alert("活动不在进行中");
                } else if (result == 3) {
                    alert("已将秒杀过此商品");
                }
            }, "json");
            // 检查条件-结束

            // 正式购买
            $.get("buy/buy", {killid:${param.killid}, goodsid:${param.goodsid}, userid: id}, function (result) {
            }, "json");

            window.location.href = "orderList.jsp";
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
<h1>商品详情</h1>
<a href="killGoodsList.html">返回商品列表</a>
<div id="goodsName"></div>
<div id="state"></div>
<div id="goodsImg"></div>
<div id="stockcount"></div>
<form>
    购买数量: <input id="buyNum" type="number" step="1">
    <input type="button" onclick="buy()" value="购买">
</form>
</body>
</html>
