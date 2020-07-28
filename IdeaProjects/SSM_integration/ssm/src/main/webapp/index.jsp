<%--
  Created by IntelliJ IDEA.
  User: HM
  Date: 2019/12/31
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM 整合</title>
</head>
<body>
    <h3>查询</h3>
    <a href="account/findAll">测试查询所有</a><br/>

    <h3>保存</h3>
    <form action="account/saveAccount" method="post">
        姓名：<input type="text" name="name"/><br/>
        工资：<input type="text" name="money"/><br/>
        <input type="submit" value="保存"/>
    </form>
</body>
</html>
