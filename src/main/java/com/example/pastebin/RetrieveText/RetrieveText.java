package com.example.pastebin.RetrieveText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetrieveText {
    final String JDBC_URL = "jdbc:mysql://localhost:3306/pastebin";
    final String JDBC_USER = "root";
    final String JDBC_PASSWORD = "password";

    @GetMapping("/retrieve")
    public String retrieveText(@RequestParam int id) {
        String retrievedText = null;
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            String sql = "SELECT TEXTCOLUMN FROM TEXTS WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                retrievedText = resultSet.getString("TEXTCOLUMN");
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retrievedText;
    }
}
