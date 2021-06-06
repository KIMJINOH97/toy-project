package com.example.toy_project.order_list.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
    List<OrderList> findAllByOrderByPriceDesc();
}
