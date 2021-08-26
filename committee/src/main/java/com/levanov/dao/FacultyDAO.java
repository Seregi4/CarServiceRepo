package com.levanov.dao;

import com.levanov.model.Faculty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAO extends AbstractDAO {

    public List<Faculty> getAllFaculty() {

        List<Faculty> facultyList = new ArrayList<>();
        getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" select * from faculty"); // for Security
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Faculty row = new Faculty();

                row.setId(resultSet.getInt(1));
                row.setName(resultSet.getString(2));
                row.setDescription(resultSet.getString(3));


                facultyList.add(row);
            } //while
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return facultyList;
    }

    public Faculty getFacultyByName(String facultyName) {
        Faculty faculty = new Faculty();
        getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from faculty where name=?");
            preparedStatement.setString(1, facultyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                faculty.setId(resultSet.getInt(1));
                faculty.setName(resultSet.getString(2));
                faculty.setDescription(resultSet.getString(3));
            }
            //return faculty;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {


            closeConnection();
        }


        return faculty;

    }

    public Faculty getFacultyByID(int facultyId) {
        Faculty faculty = new Faculty();
        getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from faculty where id=?");
            preparedStatement.setInt(1, facultyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                faculty.setId(resultSet.getInt(1));
                faculty.setName(resultSet.getString(2));
                faculty.setDescription(resultSet.getString(3));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            closeConnection();
        }

        return faculty;

    }

    public boolean insertFaclulty(Faculty faculty) {


        boolean itWorked = false;
        getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into faculty (name, description ) values (?,?)");

            preparedStatement.setString(1, faculty.getName());
            preparedStatement.setString(2, faculty.getDescription());


            itWorked = preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return itWorked;
    }

    public boolean updateFaculty(Faculty faculty) {
        boolean isFacultyUpdate = false;


        getConnection();
        try {
            String SQL_UPDATE = "UPDATE  faculty SET  name = ?, description = ? WHERE id =? ";   //3

            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);


            ps.setString(1, faculty.getName());
            ps.setString(2, faculty.getDescription());
            ps.setInt(3, faculty.getId());

            isFacultyUpdate = ps.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("SQL Error is =" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return isFacultyUpdate;
    }

    public boolean deletesFacultyById(int id) {
        boolean isFacultyDeleted = false;
        getConnection();
        try {
            String SQL_INSERT = " DELETE from faculty where id= ? ";

            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1, id);


            isFacultyDeleted = ps.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }


        return isFacultyDeleted;

    }
}
