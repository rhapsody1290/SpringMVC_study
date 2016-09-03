<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2016/9/3
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/SpringMVC_study/test11.do">
        用户1：<input type="text" name="users[0].userName"/><br/>
        用户2：<input type="text" name="users[1].userName"/><br/>
        用户3：<input type="text" name="users[2].userName"/><br/>
        <input type="submit" value="测试"/>
    </form>
</body>
</html>
