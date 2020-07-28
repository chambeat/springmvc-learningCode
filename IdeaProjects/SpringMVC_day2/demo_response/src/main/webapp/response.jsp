<%--
  Created by IntelliJ IDEA.
  User: HM
  Date: 2019/12/27
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>响应demo</title>
    <%-- 引入jquery以便使用其API --%>
    <script src="js/jquery-3.3.1.min.js"></script>

    <script>
        // 页面加载，绑定单击事件
        $(function () {
            $("#btnAjax").click(function () {
                // 发送ajax请求
                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=utf-8",
                    data: '{"username": "张三", "password": "chm", "age": 30}',
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        // data：服务器响应的json格式数据
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            })
        });
    </script>
</head>

<body>
<%--<a href="user/testString">响应之返回值是String类型</a>--%>

<%--<a href="user/testVoid">响应之返回值是void类型</a>--%>

<%--<a href="user/testModelAndView">响应之返回值是ModelAndView类型</a>--%>

<%--<a href="user/testForwardOrRedirect">响应之testForwardOrRedirect</a>--%>

<button id="btnAjax">发送ajax请求</button>
</body>
</html>
