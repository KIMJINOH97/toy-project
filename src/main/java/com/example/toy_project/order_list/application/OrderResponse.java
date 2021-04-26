package com.example.toy_project.order_list.application;

import com.example.toy_project.order_list.domain.OrderList;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OrderResponse {
    private Long id;
    private String name;
    private Integer price;
    private Integer count;

    public OrderResponse(OrderList list){
        this.id = list.getId();
        this.name = list.getName();
        this.price = list.getPrice();
        this.count = list.getCount();
    }
}
