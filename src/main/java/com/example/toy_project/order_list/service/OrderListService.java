package com.example.toy_project.order_list.service;

import com.example.toy_project.order_list.application.OrderResponse;
import com.example.toy_project.order_list.domain.OrderList;
import com.example.toy_project.order_list.domain.OrderListRepository;
import com.example.toy_project.picture.domain.Picture;
import com.example.toy_project.picture.domain.PictureRepository;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderListService {
    private final OrderListRepository orderListRepository;
    private final PictureRepository pictureRepository;

    @Transactional
    public OrderResponse save(MultipartFile file, String name, String price, String count) throws IOException {
        byte [] picture = file.getBytes();
        Long pid = pictureRepository.save(new Picture(picture)).getId();
        OrderList orderList = new OrderList(name, Integer.parseInt(price), Integer.parseInt(count), pid);
        return new OrderResponse(orderListRepository.save(orderList));
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findAll(){
        List<OrderResponse> orderResponses = new ArrayList<>();
        orderListRepository.findAll().forEach((order)-> orderResponses.add(new OrderResponse(order)));
        return orderResponses;
    }

    @Transactional(readOnly = true)
    public OrderResponse findById(Long id){
        Optional<OrderList> orderList = orderListRepository.findById(id);
        if (orderList == null){
            return new OrderResponse();
        } else {
            return new OrderResponse(orderList.get());
        }
    }

}
