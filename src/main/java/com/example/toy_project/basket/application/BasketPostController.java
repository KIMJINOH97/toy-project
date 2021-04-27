package com.example.toy_project.basket.application;

import com.example.toy_project.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BasketPostController {
    private final BasketService basketService;

    @GetMapping("/user/{user_id}/basket")
    public List<BasketResponse> findUserBasket(@PathVariable(name = "user_id") Long user_id){
        return basketService.findUserBasket(user_id);
    }
}
