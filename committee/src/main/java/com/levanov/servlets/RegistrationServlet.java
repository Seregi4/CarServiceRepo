package com.levanov.servlets;

import com.levanov.dao.UserDAO;
import com.levanov.model.User;
import com.levanov.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/JSP/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("confirm");
        String email = req.getParameter("email");

//        Objects.requireNonNull(name, "bar must not be null");
//        Objects.requireNonNull(password, "bar must not be null");
//        Objects.requireNonNull(passwordConfirm, "bar must not be null");
//        Objects.requireNonNull(email, "bar must not be null");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);

        UserDAO userDAO = new  UserDAO();
        userDAO.insertUser(user);

  //      UserService userService = new UserService();
   //     userService.createUser(name,password,email);
        System.out.println(name + password + email);
        req.getRequestDispatcher("WEB-INF/JSP/index.jsp").forward(req, resp);
    }


}
