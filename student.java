package com.studentinfo.model;

import java.util.Date;

public class Student {
    private int studentId;
    private int userId;
    private String studentNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private Date enrollmentDate;
    private String status;

    public Student() {}

    public Student(String studentNumber, String firstName, String lastName,
                   Date dateOfBirth, String gender, String email, String phone,
                   String address) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = "Active";
    }

    // getters & setters (same as your code)
}
