package com.example.guest.chatapplication.models;

public class Text {
    private String text;
    private String UserId;


    public Text(String text, String userId) {
        this.text = text;
        UserId = userId;
    }

    public String getText() {
        return text;
    }

    public String getUserId() {
        return UserId;
    }
}
