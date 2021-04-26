package com.example.toy_project.user.application;

import com.example.toy_project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserPostController {
    private final UserService userService;

    @PostMapping("/user")
    public UserPostResponse save(@RequestBody UserPostRequest request){
        return userService.save(request);
    }
}
