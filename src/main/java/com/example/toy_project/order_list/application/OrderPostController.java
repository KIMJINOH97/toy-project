package com.example.toy_project.order_list.application;

import com.example.toy_project.order_list.service.OrderListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OrderPostController {
    private final OrderListService orderListService;

    @GetMapping("/order-list")
    public List<OrderResponse> findAll(){
        return orderListService.findAll();
    }

    @GetMapping("/order-list/{id}")
    public OrderResponse findById(@PathVariable Long id){
        return orderListService.findById(id);
    }
}
