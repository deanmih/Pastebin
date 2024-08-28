package com.example.pastebin.AddText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddText {
    final String JDBC_URL = "jdbc:mysql://localhost:3306/pastebin";
    final String JDBC_USER = "root";
    final String JDBC_PASSWORD = "password";

    @PostMapping("/addToTable")
    public void addTxt(@RequestBody TextRequest request) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO TEXTS (ID, TEXTCOLUMN) VALUES (" + request.getId() + ", '" + request.getString() + "')";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public static class TextRequest {
        private int id;
        private String string;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

}