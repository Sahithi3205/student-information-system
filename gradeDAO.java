package com.studentinfo.dao;

import com.studentinfo.model.Grade;
import com.studentinfo.util.DatabaseConnection;

import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {

    public boolean enterGrade(Grade g, ServletContext context) throws Exception {
        String sql = "INSERT INTO grades (enrollment_id, score, max_score) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(context);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, g.getEnrollmentId());
            ps.setDouble(2, g.getScore());
            ps.setDouble(3, g.getMaxScore());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Grade> getGradesByStudent(int studentId, ServletContext context)
            throws Exception {

        List<Grade> list = new ArrayList<>();
        String sql = "SELECT * FROM grades";

        try (Connection conn = DatabaseConnection.getConnection(context);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Grade g = new Grade();
                g.setGradeId(rs.getInt("grade_id"));
                list.add(g);
            }
        }
        return list;
    }
}
