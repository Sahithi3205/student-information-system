package com.studentinfo.dao;

import com.studentinfo.model.Enrollment;
import com.studentinfo.util.DatabaseConnection;

import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    public boolean enrollStudent(Enrollment e, ServletContext context) throws Exception {
        String sql = "INSERT INTO enrollments (student_id, course_id, status) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(context);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getStudentId());
            ps.setInt(2, e.getCourseId());
            ps.setString(3, e.getStatus());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId, ServletContext context)
            throws Exception {

        List<Enrollment> list = new ArrayList<>();
        String sql = "SELECT * FROM enrollments WHERE student_id=?";

        try (Connection conn = DatabaseConnection.getConnection(context);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Enrollment e = new Enrollment();
                e.setEnrollmentId(rs.getInt("enrollment_id"));
                list.add(e);
            }
        }
        return list;
    }
}
