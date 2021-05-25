<%@ page import="java.util.List" %>
<%@ page import="com.levanov.model.Faculty" %>
<%@ page import="com.levanov.dao.FacultyDAO" %><%--
  Created by IntelliJ IDEA.
  User: Seregi4
  Date: 25.05.2021
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specialty</title>
</head>
<body>
<div><h1>Create Specialty</h1></div>
<form action="/new_specialty" class="create_specialty" method="post">

    <input type="text" name="name_specialty" placeholder="Name specialty"></br>

       <% FacultyDAO facultyDAO = new FacultyDAO();
    List<Faculty> faculties = facultyDAO.getAllFaculty();
    for (Faculty faculty:faculties ) {
        faculty.toString();
} %>

    <button type="submit">Confirm</button>
</form>

</body>
</html>
