package com.example.toy_project.user.service;

import com.example.toy_project.basket.domain.Basket;
import com.example.toy_project.basket.domain.BasketRepository;
import com.example.toy_project.order_list.domain.OrderList;
import com.example.toy_project.order_list.domain.OrderListRepository;
import com.example.toy_project.user.application.UserPostRequest;
import com.example.toy_project.user.domain.User;
import com.example.toy_project.user.domain.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;
    @Autowired private OrderListRepository orderListRepository;
    @Autowired private BasketRepository basketRepository;

    @AfterEach
    public void delete(){
        userRepository.deleteAll();
    }

    @Test
    public void save(){
        //given
        String name1 = "name1";
        String name2 = "name2";

        UserPostRequest request = new UserPostRequest(name1);
        UserPostRequest request2 = new UserPostRequest(name2);
        //when
        userService.save(request);
        userService.save(request2);

        //then
        List<User> all = userRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

    }

    @Test
    public void saveBasket(){
        //given
        String user_name = "jinoh";

        String order_name = "감자";
        int price = 1000;
        int count = 1000;
        User user = new User(user_name);
        OrderList orderList = new OrderList(order_name, price, count);

        //when
        userRepository.save(user);
        orderListRepository.save(orderList);
        userService.saveBasket(1L, 1L);

        //then
        Basket basket = basketRepository.findById(1L).get();
        assertThat(basket.getUser().getName()).isEqualTo(user_name);
    }
}