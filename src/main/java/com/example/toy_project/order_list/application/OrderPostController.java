package com.example.toy_project.order_list.application;

import com.example.toy_project.apiform.ApiForm;
import com.example.toy_project.order_list.service.OrderListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static com.example.toy_project.apiform.ApiForm.succeed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OrderPostController {
    private final OrderListService orderListService;

    @PostMapping("/order-list")
    public ApiForm<OrderResponse> save(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
                              @RequestParam("price") String price, @RequestParam("count") String count) throws IOException {
        return succeed(orderListService.save(file ,name, price, count), "");
    }

    @GetMapping("/order-list")
    public ApiForm<List<OrderResponse>> findAll(){
        return succeed(orderListService.findAll(), "");
    }

    @GetMapping("/order-list/{id}")
    public ApiForm<OrderResponse> findById(@PathVariable Long id){
        return succeed(orderListService.findById(id),"");
    }

}
