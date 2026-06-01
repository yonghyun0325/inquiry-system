package com.example.inquirysystem.user;

import lombok.Getter;

@Getter
public class UserMeResponse {

    private final Long id;
    private final String email;
    private final String name;
    private final String role;

    public UserMeResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.role = user.getRole();
    }
}