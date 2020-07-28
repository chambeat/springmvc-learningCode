<%--
  Created by IntelliJ IDEA.
  User: HM
  Date: 2019/12/31
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--使用jstl(已被淘汰，少用)--%>
<html>
<head>
    <title>执行成功</title>
</head>
<body>
    <h3>查询所有的账户</h3>
    <%--${accounts}--%>

    <%--使用jstl打印查询到的账户信息--%>
    <c:forEach items="${accounts}" var="account">
        ${account.name}
    </c:forEach>
</body>
</html>
