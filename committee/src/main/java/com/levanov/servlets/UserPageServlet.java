package com.levanov.servlets;

import com.levanov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("userFromDB");
        if (user == null) {
            req.setAttribute("errMessage", "login doesn't exist");
            req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);
        } else if (user.getRoleID() == 1) {
            req.getRequestDispatcher("WEB-INF/JSP/adminPage.jsp").forward(req, resp);
        } else if (user.getRoleID() == 2) {
            req.getRequestDispatcher("WEB-INF/JSP/userPage.jsp").forward(req, resp);
        } else if (user.getRoleID() == 3) {
            req.setAttribute("errMessage", "login doesn't exist");
            req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
