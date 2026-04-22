package com.studentinfo.model;

public class Course {
    private int courseId;
    private String courseCode;
    private String courseName;
    private String description;
    private int credits;
    private String instructor;
    private String semester;
    private String academicYear;
    private int maxCapacity;
    private int currentEnrollment;
    private String status;

    public Course() {}

    public Course(String courseCode, String courseName, String description,
                  int credits, String instructor, String semester, String academicYear) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.credits = credits;
        this.instructor = instructor;
        this.semester = semester;
        this.academicYear = academicYear;
        this.maxCapacity = 30;
        this.currentEnrollment = 0;
        this.status = "Active";
    }

    // getters & setters
}
