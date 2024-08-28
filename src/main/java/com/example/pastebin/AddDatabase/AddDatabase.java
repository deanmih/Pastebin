package com.example.pastebin.AddDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddDatabase {
    final String JDBC_URL = "jdbc:mysql://localhost:3306/pastebin";
    final String JDBC_USER = "root";
    final String JDBC_PASSWORD = "password";
    @PostMapping("/addDB")
    public void createDB() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql2 = "DELETE FROM TEXTS;";
            String sql1 = "CREATE TABLE IF NOT EXISTS TEXTS (" +
                         "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                         "TEXT_CONTENT TEXT NOT NULL" +
                         ");";
            statement.execute(sql1);
            statement.execute(sql2);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
