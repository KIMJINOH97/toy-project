package com.example.toy_project.basket.domain;

import com.example.toy_project.order_list.domain.OrderList;
import com.example.toy_project.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Basket {
    @Id
    @Column(name = "basket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderList orderList;

    public void setUser(User user){
        this.user = user;
    }

    public void setOrderList(OrderList orderList){
        this.orderList = orderList;
    }
}
