package com.compasso.uol.exceptions.vo;

public class ConstraintErrorModel {

    private String userMessage;

    private String message;

    private Object details;

    public ConstraintErrorModel() {}

    public ConstraintErrorModel(String userMessage, String message, Object details) {
        this.userMessage = userMessage;
        this.message = message;
        this.details = details;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }
}
