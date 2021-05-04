package com.example.toy_project.user.application;

import com.example.toy_project.apiform.ApiForm;
import com.example.toy_project.user.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{id}/basket/{order_id}")
    public ApiForm<?> saveBasket(@PathVariable Long id, @PathVariable Long order_id){
        return userService.saveBasket(id, order_id);
    }

    @DeleteMapping("/user/{id}/basket/{order_id}")
    public ApiForm<?> deleteBasket(@PathVariable Long id, @PathVariable Long order_id){
        return userService.deleteBasket(id, order_id);
    }
}
