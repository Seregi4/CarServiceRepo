<%--
  Created by IntelliJ IDEA.
  User: Seregi4
  Date: 17.05.2021
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Login</title>
    <style>
        <%@include file='/WEB-INF/CSS/login.css' %>
    </style>
</head>
<body>
<h1>Login</h1>
<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></span>
<form action="/login" class="login" method="post">


    <input type="email" name="email" placeholder="your email">
    <input type="password" name="password" placeholder="password">

    <button class="button-login" type="submit">Confirm</button>
</form>

</body>
</html>
