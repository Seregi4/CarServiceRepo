package com.levanov.servlets;

import com.levanov.dao.FacultyDAO;
import com.levanov.model.Faculty;
import com.levanov.service.BriefDescription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FacultyDAO facultyDAO = new FacultyDAO();
        List<Faculty> facultyList = facultyDAO.getAllFaculty();
        req.setAttribute("faculties", facultyList);
        req.getRequestDispatcher("WEB-INF/JSP/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
