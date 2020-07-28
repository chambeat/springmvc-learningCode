<%--
  Created by IntelliJ IDEA.
  User: HM
  Date: 2019/12/28
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <%-- JavaWeb方式 --%>
<%--
    <form action="user/fileUpload1" method="post" enctype="multipart/form-data">
        ---请选择文件---&nbsp;&nbsp;<input type="file" name="upload"/><br/>
        <input type="submit" value="提交"/>
    </form>
--%>

    <%-- SpringMVC方式 --%>
<%--
    <form action="user/fileUpload2" method="post" enctype="multipart/form-data">
        ---请选择文件---&nbsp;&nbsp;<input type="file" name="upload"/><br/>
        <input type="submit" value="提交"/>
    </form>
--%>

    <%-- 跨服务器文件上传 --%>
    <h3>跨服务器文件上传</h3>
    <form action="user/fileUpload3" method="post" enctype="multipart/form-data">
        ---请选择文件---&nbsp;&nbsp;<input type="file" name="upload"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
