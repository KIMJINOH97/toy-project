package com.example.toy_project.order_list.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "order_list")
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    private String name;
    private Integer price;
    private Integer count;

    public OrderList(String name, Integer price, Integer count){
        this.name = name;
        this.price = price;
        this.count = count;
    }
}
