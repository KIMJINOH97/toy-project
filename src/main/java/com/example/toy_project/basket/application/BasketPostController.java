package com.example.toy_project.basket.application;

import com.example.toy_project.apiform.ApiForm;
import com.example.toy_project.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.toy_project.apiform.ApiForm.succeed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BasketPostController {
    private final BasketService basketService;

    @GetMapping("/user/{user_id}/basket")
    public ApiForm<List<BasketResponse>> findUserBasket(@PathVariable(name = "user_id") Long user_id){
        return succeed(basketService.findUserBasket(user_id), "");
    }

    @DeleteMapping("/basket/{id}")
    public ApiForm<Long> delete(@PathVariable Long id){
        return succeed(basketService.delete(id), "삭제 되었습니다.");
    }

}
