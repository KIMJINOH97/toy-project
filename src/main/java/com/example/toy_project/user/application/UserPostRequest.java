package com.example.toy_project.user.application;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserPostRequest {
    private String name;

    public UserPostRequest(String name){
        this.name = name;
    }
}
