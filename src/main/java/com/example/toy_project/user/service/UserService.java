package com.example.toy_project.user.service;

import com.example.toy_project.basket.domain.Basket;
import com.example.toy_project.basket.domain.BasketRepository;
import com.example.toy_project.order_list.domain.OrderListRepository;
import com.example.toy_project.user.application.UserPostRequest;
import com.example.toy_project.user.application.UserPostResponse;
import com.example.toy_project.user.domain.User;
import com.example.toy_project.user.domain.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final OrderListRepository orderListRepository;
    private final BasketRepository basketRepository;

    @Transactional
    public UserPostResponse save(UserPostRequest request){
        Optional<User> user = userRepository.findByName(request.getName());
        if (user.isPresent()){
            return new UserPostResponse(user.get());
        }
        // 찾는 User가 없으면 새로 만들어 줌
        return new UserPostResponse(userRepository.save(new User(request)));
    }

    @Transactional
    public UserPostResponse saveBasket(Long id, Long order_id){
        Basket basket = new Basket();
        userRepository.findById(id).ifPresent((u) -> basket.setUser(u));
        orderListRepository.findById(order_id).ifPresent((order) -> basket.setOrderList(order));
        basketRepository.save(basket);
        return new UserPostResponse();
    }

}
