package org.swsc.com.model;

import org.swsc.com.DTO.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    public void insert(Student student) {
        try {
            DbConnection dbConnection = new DbConnection();
            System.out.println("Connected to PostgreSql successfully");

            String query = "INSERT INTO student (name, hobbies, address, gender) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);

            statement.setString(1, student.getName());
            statement.setString(2, student.getHobbies());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getGender());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Student inserted successfully");
            }

        } catch (SQLException e) {
            System.out.println("Insert failed");
            e.printStackTrace();
        }
    }

    public List<Student> selectAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            DbConnection dbConnection = new DbConnection();
            System.out.println("Connected to PostgreSql successfully");

            String query = "select * from student";
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setHobbies(resultSet.getString("hobbies"));
                student.setAddress(resultSet.getString("address"));
                student.setGender(resultSet.getString("gender"));

                studentList.add(student);
            }

            System.out.println("Data fetched successfully");

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        return studentList;
    }
    public void delete()  {
        DbConnection dbConnection = new DbConnection();
        System.out.println("Connected to PostgreSql successfully");

        String query = "delete from student ";
        PreparedStatement statement = null;
        try {
            statement = dbConnection.getConnection().prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    // update
    //delete
    // get by id
}
