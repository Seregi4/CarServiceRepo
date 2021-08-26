package com.levanov.servlets;

import com.levanov.dao.FacultyDAO;
import com.levanov.dao.SpecialtyDAO;
import com.levanov.model.Faculty;
import com.levanov.model.Specialty;
import com.levanov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/faculty")
public class FacultyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Faculty faculty = new FacultyDAO().getFacultyByID(id);
        List<Specialty> specialties = new SpecialtyDAO().getSpecialtyByFacultyId(id);
        req.setAttribute("fac", faculty);
        req.setAttribute("listspec", specialties);

        req.getRequestDispatcher("WEB-INF/JSP/faculty.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("userFromDB");

        if (user.getRoleID() == 2) {
            int specialityId = Integer.parseInt(req.getParameter("spec-id"));
            req.setAttribute("spec-id",specialityId);

            req.getRequestDispatcher("WEB-INF/JSP/userQuestionnaire.jsp").forward(req, resp);

        } else req.setAttribute("errMessage", "login doesn't exist");
        req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);
    }
}
