package com.example.toy_project.order_list.service;

import com.example.toy_project.order_list.application.OrderResponse;
import com.example.toy_project.order_list.domain.OrderList;
import com.example.toy_project.order_list.domain.OrderListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderListService {
    private final OrderListRepository orderListRepository;

    public List<OrderResponse> findAll(){
        List<OrderResponse> orderResponses = new ArrayList<>();
        orderListRepository.findAll().forEach((order)-> orderResponses.add(new OrderResponse(order)));
        return orderResponses;
    }

    public OrderResponse findById(Long id){
        Optional<OrderList> orderList = orderListRepository.findById(id);
        if (orderList == null){
            return new OrderResponse();
        } else {
            return new OrderResponse(orderList.get());
        }
    }

}
