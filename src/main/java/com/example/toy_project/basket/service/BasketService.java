package com.example.toy_project.basket.service;

import com.example.toy_project.basket.application.BasketResponse;
import com.example.toy_project.basket.domain.Basket;
import com.example.toy_project.basket.domain.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BasketService {
    private final BasketRepository basketRepository;

    @Transactional(readOnly = true)
    public List<BasketResponse> findUserBasket(Long id){
        List<BasketResponse> basketResponses = new ArrayList<>();
        basketRepository.findByUserId(id).forEach((basket)->
                basketResponses.add(new BasketResponse(basket.getOrderList()))
        );
        return basketResponses;
    }

    @Transactional
    public Long delete(Long id){
        Basket basket = basketRepository.findById(id).get();
        basket.setUser(null);
        basket.setOrderList(null);
        basketRepository.deleteById(id);
        return id;
    }
}
