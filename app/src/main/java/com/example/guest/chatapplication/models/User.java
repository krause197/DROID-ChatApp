package com.example.guest.chatapplication.models;

/**
 * Created by Guest on 12/7/16.
 */
public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String userId;
    private String pushId;
    private String imageUrl;

    public User(){};

    public User(String name, String email, String phoneNumber, String userId, String imageUrl) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getPushId() {
        return pushId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
