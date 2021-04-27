package com.example.toy_project.basket.service;

import com.example.toy_project.basket.application.BasketResponse;
import com.example.toy_project.basket.domain.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BasketService {
    private final BasketRepository basketRepository;

    public List<BasketResponse> findUserBasket(Long id){
        List<BasketResponse> basketResponses = new ArrayList<>();
        basketRepository.findByUserId(id).forEach((basket)->
                basketResponses.add(new BasketResponse(basket.getOrderList()))
        );
        return basketResponses;
    }
}
