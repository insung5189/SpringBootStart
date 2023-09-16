package com.example.sbb.chatbot.domain;

public class WelcomeMessage {

    private String message;

    public WelcomeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}