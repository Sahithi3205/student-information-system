package com.studentinfo.model;

import java.util.Date;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private Date enrollmentDate;
    private String status;
    private String studentName;
    private String courseName;
    private String courseCode;

    public Enrollment() {}

    public Enrollment(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = "Enrolled";
    }

    // getters & setters
}
