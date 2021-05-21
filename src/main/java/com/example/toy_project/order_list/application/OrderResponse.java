package com.example.toy_project.order_list.application;

import com.example.toy_project.order_list.domain.OrderList;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mapping.model.PropertyNameFieldNamingStrategy;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderResponse {
    private Long orderId;
    private String orderName;
    private String url;
    private int price;
    private int count;

    public OrderResponse(OrderList list){
        this.orderId = list.getId();
        this.orderName = list.getName();
        this.price = list.getPrice();
        this.count = list.getCount();

        String fileUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/files/")
                .path(String.valueOf(list.getId()))
                .toUriString();

        this.url = fileUrl;
    }
}
