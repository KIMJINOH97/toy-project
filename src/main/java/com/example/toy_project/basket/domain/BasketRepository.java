package com.example.toy_project.basket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    List<Basket> findByUserIdOrderByOrderList(Long id);

    @Query("select b from Basket b where b.user.id = ?1 and b.orderList.id = ?2")
    Optional<Basket> findByUserIdAndOrderId(Long id, Long orderId);
}
