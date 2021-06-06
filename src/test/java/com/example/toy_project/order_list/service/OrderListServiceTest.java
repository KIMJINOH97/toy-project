package com.example.toy_project.order_list.service;

import com.example.toy_project.order_list.application.OrderResponse;
import com.example.toy_project.order_list.domain.OrderList;
import com.example.toy_project.order_list.domain.OrderListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderListServiceTest {
    @Autowired private OrderListService orderListService;
    @Autowired private OrderListRepository orderListRepository;

    @Test
    public void findAll(){
        //given
        String name1 = "감자";
        String name2 = "딸기";

        Integer price = 1000;
        Integer count = 100;

        //when
        orderListRepository.save(new OrderList(name1, price, count));
        orderListRepository.save(new OrderList(name2, price, count));

        //then
        assertThat(orderListService.findAll().size()).isEqualTo(2);
    }

    @Test
    public void findById(){
        //given
        String name1 = "감자";
        String name2 = "딸기";

        Integer price = 10000;
        Integer count = 1000;

        //when
        orderListRepository.save(new OrderList(name1, price, count));
        orderListRepository.save(new OrderList(name2, price, count));

        //then
        assertThat(orderListService.findById(2L).getOrderName()).isEqualTo(name2);
    }

    @Test
    public void orderByPrice(){
        List<OrderResponse> orderResponses = orderListService.orderByPrice();
        assertThat(orderResponses.get(0).getPrice()).isEqualTo(3000);
    }

}