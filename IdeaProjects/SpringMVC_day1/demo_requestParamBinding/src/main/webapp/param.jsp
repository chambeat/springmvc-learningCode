<%--
  Created by IntelliJ IDEA.
  User: HM
  Date: 2019/12/22
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
<%--<h3>请求参数绑定</h3>
<a href="testRequestParam">测试请求参数绑定</a>--%>

<%--
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        工资：<input type="text" name="money"/><br/>
        <input type="submit" value="提交"/>
    </form>
--%>

<%--
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        工资：<input type="text" name="money"/><br/>
        昵称：<input type="text" name="user.uname"/><br/>
        年龄：<input type="text" name="user.age"/><br/>
        <input type="submit" value="提交"/>
    </form>
--%>

<%--
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        工资：<input type="text" name="money"/><br/>

        昵称：<input type="text" name="list[0].uname"/><br/>
        年龄：<input type="text" name="list[0].age"/><br/>

        昵称：<input type="text" name="map['one'].uname"/><br/>
        年龄：<input type="text" name="map['one'].age"/><br/>
        <input type="submit" value="提交"/>
    </form>
--%>

<%--
<form action="api/printInfo" method="post">
    昵称：<input type="text" name="uname"/><br/>
    年龄：<input type="text" name="age"/><br/>
    生日：<input type="text" name="date"/><br/>
    <input type="submit" value="提交"/>
</form>
--%>

    <a href="api/printInfo">测试获取Servlet原生API</a>
</body>
</html>
