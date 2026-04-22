package com.studentinfo.model;

import java.util.Date;

public class Grade {
    private int gradeId;
    private int enrollmentId;
    private String assignmentType;
    private double score;
    private double maxScore;
    private String gradeLetter;
    private String semester;
    private String academicYear;
    private Date enteredDate;

    public Grade() {}

    private String calculateGradeLetter(double score, double maxScore) {
        double percentage = (score / maxScore) * 100;
        if (percentage >= 90) return "A";
        if (percentage >= 80) return "B";
        if (percentage >= 70) return "C";
        if (percentage >= 60) return "D";
        return "F";
    }

    // getters & setters
}
