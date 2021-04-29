package com.example.toy_project.order_list.application;

import com.example.toy_project.order_list.domain.OrderList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@NoArgsConstructor
@Getter
public class OrderResponse {
    private Long id;
    private String name;
    private String url;
    private Integer price;
    private Integer count;

    public OrderResponse(OrderList list){
        this.id = list.getId();
        this.name = list.getName();
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
