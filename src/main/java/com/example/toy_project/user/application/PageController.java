package com.example.toy_project.user.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String index(){
        return "index/index.html";
    }

    @GetMapping("/order-list")
    public String orders(){
        return "order/order.html";
    }

    @GetMapping("/order-item")
    public String orderItem() {
        return "orderItem/orderItem.html"; }

    @GetMapping("/basket")
    public String basket() { return "/basket/basket.html";}
}
