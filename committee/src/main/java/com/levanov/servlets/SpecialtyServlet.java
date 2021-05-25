package com.levanov.servlets;

import com.levanov.dao.FacultyDAO;
import com.levanov.model.Faculty;
import com.levanov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/new_specialty")
public class SpecialtyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("userFromDB");
        System.out.println(user.getRoleID());
        if (user.getRoleID() == 1) {
          //  FacultyDAO facultyDAO = new FacultyDAO();
        //  req.setAttribute("Facultys", facultyDAO.getAllFaculty());
            String[] users = new String[]{"Tom", "Bob", "Sam"};
            req.setAttribute("users", users);
            req.getRequestDispatcher("WEB-INF/JSP/createSpecialty.jsp").forward(req, resp);
        } else req.setAttribute("errMessage", "login doesn't exist");
        req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        //TODO добавить проверки
//        User user = (User) session.getAttribute("userFromDB");
//        if (user.getRoleID() == 1) {
//            createFaculte(req.getParameter("name_faculty"), req.getParameter("faculty_description"));
//            req.getRequestDispatcher("WEB-INF/JSP/createFaculty.jsp").forward(req, resp);
//
//        } else req.setAttribute("errMessage", "login doesn't exist");
//        req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);
//
//        super.doPost(req, resp);
//    }
//
//    private boolean createFaculte(String name, String description) {
//        Faculty faculty = new Faculty(name, description);
//        FacultyDAO facultyDAO = new FacultyDAO();
//        facultyDAO.insertFaclulty(faculty);
//        return true;
  }
}
