package com.levanov.service;

import com.levanov.dao.UserDAO;
import com.levanov.model.User;


public class UserService  {




    public void createUser(String name, String password,String email){
        User user = new User();
        UserDAO userDAO = new UserDAO();
        user.setName(name);
        user.setPassword(password);
        user.setName(email);
        userDAO.insertUser(user);
         }

}
