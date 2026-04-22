package com.studentinfo.util;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection(ServletContext context) throws Exception {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "password";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
}
