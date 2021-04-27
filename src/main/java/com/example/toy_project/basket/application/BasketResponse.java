package com.example.toy_project.basket.application;

import com.example.toy_project.order_list.domain.OrderList;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BasketResponse {
    private Long order_id;
    private String order_name;
    private Integer price;
    private Integer count;

    public BasketResponse(OrderList orderList){
        this.order_id = orderList.getId();
        this.order_name = orderList.getName();
        this.price = orderList.getPrice();
        this.count = orderList.getCount();
    }

}
