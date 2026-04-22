package com.studentinfo.dao;

import com.studentinfo.model.Course;
import com.studentinfo.util.DatabaseConnection;

import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public boolean createCourse(Course c, ServletContext context) throws Exception {
        String sql = "INSERT INTO courses (course_code, course_name, credits) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(context);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getCourseCode());
            ps.setString(2, c.getCourseName());
            ps.setInt(3, c.getCredits());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Course> getAllCourses(ServletContext context) throws Exception {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM courses";

        try (Connection conn = DatabaseConnection.getConnection(context);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt("course_id"));
                c.setCourseName(rs.getString("course_name"));
                list.add(c);
            }
        }
        return list;
    }
}
