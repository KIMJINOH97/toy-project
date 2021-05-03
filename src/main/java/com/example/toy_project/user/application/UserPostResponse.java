package com.example.toy_project.user.application;

import com.example.toy_project.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserPostResponse {
    private Long id;
    private String name;

    public UserPostResponse(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
    
}
