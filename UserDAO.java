package com.studentinfo.dao;

import com.studentinfo.util.DatabaseConnection;
import javax.servlet.ServletContext;
import java.sql.*;

public class UserDAO {

    public boolean validateUser(String username, String password, ServletContext context)
            throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection(context);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }
}
