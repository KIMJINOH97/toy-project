package com.example.toy_project.user.service;

import com.example.toy_project.user.application.UserPostRequest;
import com.example.toy_project.user.application.UserPostResponse;
import com.example.toy_project.user.domain.User;
import com.example.toy_project.user.domain.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserPostResponse save(UserPostRequest request){
        User user = userRepository.save(new User(request));
        return new UserPostResponse(user);
    }

}
