package com.levanov.dao;



import com.levanov.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO {
    //CRUD  - create, update, delete, insert

    /**
     * This method gets all users from table
     *
     * @return
     */
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<User>();
        getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" select * from user_account"); // for Security
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                User row = new User();

               // row.setId(resultSet.getInt(1));
                row.setName(resultSet.getString(2));
                row.setPassword(resultSet.getString(3));
                row.setEmail(resultSet.getString(4));
                row.setRoleID(resultSet.getInt(5));


                users.add(row);
            } //while
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return users;

    }


    public User getUserById(int id) {
        User user = new User();
        getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_account where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User row = new User();


                row.setId(resultSet.getInt(1));
                row.setName(resultSet.getString(2));
                row.setPassword(resultSet.getString(3));
                row.setEmail(resultSet.getString(4));
                row.setRoleID(resultSet.getInt(5));

                user = row;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return user;

    }


    public User getUsersByUsername(String username) {
        User user = new User();
        getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_account where user_name=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setRoleID(resultSet.getInt(5));

            }
            //return user;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {


            closeConnection();
        }


        return user;

    }
    public User getUsersByUserEmail(String userEmail) {
        User user = new User();
        getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_account where user_email=?");
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setRoleID(resultSet.getInt(5));

            }
            //return user;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {


            closeConnection();
        }


        return user;

    }


    /**
     * @param user
     * @return
     */
    public boolean insertUser(User user) {

        /**
         private int id;
         private String name;
         private String password;
         private String  email;
         */

        boolean itWorked = false;
        getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user_account (user_name, user_password, user_email ) values (?,?,?)");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());

            itWorked = preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return itWorked;
    }


    public boolean updateUser(User user) {
        boolean isUserUpdate = false;


        getConnection();
        try {
            String SQL_UPDATE = "UPDATE  user_account SET "
                    + " user_name = ?, "  //1
                    + " user_password = ?,"      //2
                    + " user_email = ? "    //3

                    + " WHERE id =? ";   //4

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getId());

            isUserUpdate = preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("SQL Error is =" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return isUserUpdate;
    }


    /**
     * method delete User with ID from Database
     *
     * @param user_id
     * @return
     */
    public boolean deleteUserById(int user_id) {
        boolean isUserDeleted = false;
        getConnection();
        try {
            String SQL_INSERT = " DELETE from user_account where id= ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, user_id);


            isUserDeleted = preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }


        return isUserDeleted;

    }

}
