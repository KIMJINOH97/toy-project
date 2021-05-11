package com.example.toy_project.basket.service;

import com.example.toy_project.basket.application.BasketResponse;
import com.example.toy_project.basket.domain.Basket;
import com.example.toy_project.basket.domain.BasketRepository;
import com.example.toy_project.order_list.domain.OrderList;
import com.example.toy_project.order_list.domain.OrderListRepository;
import com.example.toy_project.user.domain.User;
import com.example.toy_project.user.domain.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BasketServiceTest {
    @Autowired private BasketService basketService;
    @Autowired private BasketRepository basketRepository;
    @Autowired private OrderListRepository orderListRepository;
    @Autowired private UserRepository userRepository;

    @Test
    public void findByUser_id(){
        //given
        String user_name = "jino";

        String order_name1 = "딸기";
        String order_name2 = "수박";

        Integer price1 = 1000;
        Integer count1 = 10000;
        Integer price2 = 5000;
        Integer count2 = 50000;

        User user = new User(user_name);
        OrderList orderList1 = new OrderList(order_name1, price1, count1);
        OrderList orderList2 = new OrderList(order_name2, price2, count2);

        Basket basket1 = new Basket();
        basket1.setUser(user);
        basket1.setOrderList(orderList1);

        Basket basket2 = new Basket();
        basket2.setUser(user);
        basket2.setOrderList(orderList2);

        //when
        userRepository.save(user);

        orderListRepository.save(orderList1);
        orderListRepository.save(orderList2);

        basketRepository.save(basket1);
        basketRepository.save(basket2);

        // then
        List<BasketResponse> userBasket = basketService.findUserBasket(1L);
        for (BasketResponse response: userBasket){
            System.out.println("name : " + response.getOrder_name());
            System.out.println("Price = " + response.getPrice());
            System.out.println("count = " + response.getCount());
        }
        assertThat(userBasket.size()).isEqualTo(2);

    }

    void delete(){

    }

}