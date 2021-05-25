package com.levanov.servlets;

import com.levanov.dao.UserDAO;
import com.levanov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loginEmail = req.getParameter("email");
        String loginPassword = req.getParameter("password");


        User user = new User();
        UserDAO udao = new UserDAO();
        user = udao.getUsersByUserEmail(loginEmail);

        try {

            if ((user.getEmail().equals(loginEmail)) && (user.getEmail() != null) && (!user.getEmail().isEmpty())) {
                // Login through Bcryption checking
                if (loginPassword.equals(user.getPassword()))  //user.getPassword().equals(password)
                {
                    HttpSession session = null;
                    session = req.getSession(true);
                    User userFromDB = udao.getUsersByUserEmail(user.getEmail());

                    int userID = userFromDB.getId();
                    session.setAttribute("userID", userID);
                    int userRole = userFromDB.getRoleID();
                    session.setAttribute("user_role",userRole);
                    System.out.println("You did it!");

                    session.setAttribute("userFromDB",userFromDB );
                    System.out.println("you login");
                    req.setAttribute("Email", loginEmail);
                    session.setAttribute("Email", loginEmail);

                    //RequestDispatcher is used to send the control to the invoked page.
                    req.getRequestDispatcher("WEB-INF/JSP/index.jsp").forward(req, resp);


                } //if

                else {
                    System.out.println("Password doesn't match");
                    req.setAttribute("errMessage", "Wrong password");
                    req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);//forwarding the request
                }

            } else {
                System.out.println("Login doesn't match");
                req.setAttribute("errMessage", "login doesn't exist");
                req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);//forwarding the request
            }
        }// try
        catch (NullPointerException npe) {
            System.out.println("Object user is NULL");
            req.setAttribute("errMessage", "login doesn't exist");
            req.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(req, resp);//forwarding the request
        }
    }
}
