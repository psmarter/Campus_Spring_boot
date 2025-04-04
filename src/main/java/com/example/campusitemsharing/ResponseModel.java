package com.example.campusitemsharing;

public class ResponseModel {
    private String status;
    private String message;
    private UserDetails userDetails;
    private Object data;

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDetails getUserDetails() {
        return userDetails; // 添加 getter
    }

    public void setUserDetails(UserDetails userDetails) { // 添加 setter
        this.userDetails = userDetails;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
