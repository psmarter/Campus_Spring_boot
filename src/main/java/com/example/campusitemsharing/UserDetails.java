package com.example.campusitemsharing;

public class UserDetails {
    private String studentNumber;
    private String account;
    private String passwordHash;
    private String email;

    public UserDetails(String studentNumber, String account, String passwordHash, String email) {
        this.studentNumber = studentNumber;
        this.account = account;
        this.passwordHash = passwordHash;
        this.email = email;
    }

    public UserDetails() {
        studentNumber = null;
        account = null;
        passwordHash = null;
        email = null;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
