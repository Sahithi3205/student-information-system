package com.studentinfo.dao;

import com.studentinfo.model.Attendance;
import com.studentinfo.util.DatabaseConnection;

import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public boolean recordAttendance(Attendance attendance, ServletContext context)
            throws Exception {

        String sql = "INSERT INTO attendance (enrollment_id, attendance_date, status, notes) " +
                     "VALUES (?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE status=?, notes=?";

        try (Connection conn = DatabaseConnection.getConnection(context);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, attendance.getEnrollmentId());
            ps.setDate(2, new java.sql.Date(attendance.getAttendanceDate().getTime()));
            ps.setString(3, attendance.getStatus());
            ps.setString(4, attendance.getNotes());
            ps.setString(5, attendance.getStatus());
            ps.setString(6, attendance.getNotes());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Attendance> getAttendanceByStudent(int studentId, ServletContext context)
            throws Exception {

        List<Attendance> list = new ArrayList<>();

        String sql = "SELECT a.*, s.first_name, s.last_name, c.course_code " +
                     "FROM attendance a " +
                     "JOIN enrollments e ON a.enrollment_id = e.enrollment_id " +
                     "JOIN students s ON e.student_id = s.student_id " +
                     "JOIN courses c ON e.course_id = c.course_id " +
                     "WHERE e.student_id=?";

        try (Connection conn = DatabaseConnection.getConnection(context);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Attendance a = new Attendance();
                a.setAttendanceId(rs.getInt("attendance_id"));
                a.setStatus(rs.getString("status"));
                a.setCourseCode(rs.getString("course_code"));
                a.setStudentName(rs.getString("first_name") + " " + rs.getString("last_name"));
                list.add(a);
            }
        }
        return list;
    }
}
