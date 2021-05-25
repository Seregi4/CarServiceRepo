package com.levanov.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public abstract class AbstractDAO {

    public static final String URL =  "jdbc:mysql://localhost:3306/committee?useUnicode=true&characterEncoding=utf8";
    public static final  String USER = "root";
    public static final String PASSWORD="1234";

    protected Connection connection;

    // Setup connection with DB, using URL, userName and password
    public void getConnection()
    {

         Logger logger = Logger.getLogger(this.getClass().getName());

        try
        {
          //  Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);  // value come from DAO interfaces

        }
        catch(Exception e)
        {
            e.printStackTrace();
              logger.info( e.getMessage() );

        } //catch
    }

    //close Db connection
    public void closeConnection()
    {
        try
        {
            connection.close();
        } catch(Exception e) {}
    }
}
