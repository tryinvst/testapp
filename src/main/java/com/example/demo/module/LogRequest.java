package com.example.demo.module;

public class LogRequest {
    String message;

    public LogRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
