<%--
  Created by IntelliJ IDEA.
  User: Seregi4
  Date: 17.05.2021
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div><h1>Login</h1></div>
<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></span>
<form action="/login" class="login" method="post">


    <input type="email" name="email" placeholder="your email">
    <input type="password" name="password" placeholder="password">

    <button type="submit">Confirm</button>
</form>

</body>
</html>
