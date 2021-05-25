

<%--
  Created by IntelliJ IDEA.
  User: Seregi4
  Date: 25.05.2021
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>





<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="com.levanov.model.User" %>
<html>
<head>
    <title>Specialty</title>
</head>
<body>
<div><h1>Create Specialty</h1></div>
<form action="/new_specialty" class="create_specialty" method="post">

    <input type="text" name="name_specialty" placeholder="Name specialty"></br>


    <button type="submit">Confirm</button>
</form>
<%

    List<User> listusers = (List<User>)request.getAttribute("users");
    out.println("<table border='1'>");
    for(User users : listusers)
    {
        out.println("<tr>");

        out.print("<td>"+users.getId()+"</td>");
        out.print("<td>"+users.getFirstname()+"</td>");
        out.print("<td>"+users.getUsername()+"</td>");
        out.print("<td>"+users.getPassword()+"</td>");

        out.println("</tr>");
    }

    out.println("</table>");
%>
</body>
</html>
