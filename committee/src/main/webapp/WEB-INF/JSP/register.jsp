<%--
  Created by IntelliJ IDEA.
  User: Seregi4
  Date: 15.05.2021
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div><h1>Registration</h1></div>
<form action="/register" class="registration" method="post">

    <input type="text" name="name" placeholder="Your name">
    <input type="email" name="email" placeholder="your email">
    <input type="password" name="password" placeholder="password">
    <input type="password" name="confirm" placeholder="confirm password">
    <button type="submit">Confirm</button>
</form>
</body>
</html>
