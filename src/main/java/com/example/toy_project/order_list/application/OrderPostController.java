package com.example.toy_project.order_list.application;

import com.example.toy_project.order_list.service.OrderListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OrderPostController {
    private final OrderListService orderListService;

    @PostMapping("/order-list")
    public OrderResponse save(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
                              @RequestParam("price") String price, @RequestParam("count") String count) throws IOException {
        return orderListService.save(file ,name, price, count);
    }

    @GetMapping("/order-list")
    public List<OrderResponse> findAll(){
        return orderListService.findAll();
    }

    @GetMapping("/order-list/{id}")
    public OrderResponse findById(@PathVariable Long id){
        return orderListService.findById(id);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> findPictureById(@PathVariable Long id){
        return orderListService.findPictureById(id);
    }
}
