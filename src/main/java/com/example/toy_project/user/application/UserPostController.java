package com.example.toy_project.user.application;

import com.example.toy_project.apiform.ApiForm;
import com.example.toy_project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.toy_project.apiform.ApiForm.succeed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserPostController {
    private final UserService userService;

    @PostMapping("/user")
    public ApiForm<UserPostResponse> save(@RequestBody UserPostRequest request){
        return succeed(userService.save(request), "로그인 되었습니다.");
    }
}
