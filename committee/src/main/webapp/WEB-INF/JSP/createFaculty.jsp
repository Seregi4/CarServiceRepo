<%--
  Created by IntelliJ IDEA.
  User: Seregi4
  Date: 23.05.2021
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateFaculty</title>
</head>
<body>
<div><h1>CreateFaculty</h1></div>
<form action="/new_faculty" class="create_faculty" method="post">

    <input type="text" name="name_faculty" placeholder="Name faculty"></br>
    <textarea name="faculty_description"> </textarea>
    <button type="submit">Confirm</button>
</form>

</body>
</html>
