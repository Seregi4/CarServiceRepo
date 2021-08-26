<%--
  Created by IntelliJ IDEA.
  User: Seregi4
  Date: 15.05.2021
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Committee</title>
    <style>
        <%@include file='/WEB-INF/CSS/index.css' %>
    </style>
</head>
<body>
<div class="header">
    <span class=" left_panel"><a class="header-link"  href="/"> Home </a><a class="header-link" href="/user"> User </a><a class="header-link" href="/results"> Results </a></span>
    <span class=" right_panel"><a class="header-link" href="/login"> Sign in </a> <a class="header-link"  href="/register"> Create an account </a></span>

</div>
<div class="center-main" >

    <c:forEach items="${faculties}" var="faculty">
        <a href="/faculty?id=${faculty.getId()}" class="element-name" >
            <div class="element"  >
                ${faculty.getName()}
<%--                <div class="element-descr" >${brief.getBrief(faculty)}</div>--%>
            </div>
        </a>
    </c:forEach>
</div>

</body>
</html>
