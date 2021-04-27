package com.example.toy_project.basket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query("select b from Basket b where b.user.Id = ?1")
    List<Basket> findByUserId(Long id);
}
