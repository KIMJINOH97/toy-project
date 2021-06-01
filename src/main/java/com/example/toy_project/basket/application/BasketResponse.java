package com.example.toy_project.basket.application;

import com.example.toy_project.order_list.domain.OrderList;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BasketResponse {
    private Long orderId;
    private String orderName;
    private Integer price;
    private Integer count;
    private String url;

    public BasketResponse(OrderList orderList){
        this.orderId = orderList.getId();
        this.orderName = orderList.getName();
        this.price = orderList.getPrice();
        this.count = orderList.getCount();
        this.url = orderList.getUrl();
    }

}
