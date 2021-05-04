package com.example.toy_project.user.service;

import com.example.toy_project.apiform.ApiForm;
import com.example.toy_project.basket.domain.Basket;
import com.example.toy_project.basket.domain.BasketRepository;
import com.example.toy_project.order_list.domain.OrderListRepository;
import com.example.toy_project.user.application.UserPostRequest;
import com.example.toy_project.user.application.UserPostResponse;
import com.example.toy_project.user.domain.User;
import com.example.toy_project.user.domain.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.toy_project.apiform.ApiForm.failed;
import static com.example.toy_project.apiform.ApiForm.succeed;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final OrderListRepository orderListRepository;
    private final BasketRepository basketRepository;

    @Transactional
    public UserPostResponse save(UserPostRequest request){
        Optional<User> user = userRepository.findByName(request.getName());
        if (user.isPresent()){
            return new UserPostResponse(user.get());
        }
        // 찾는 User가 없으면 새로 만들어 줌
        return new UserPostResponse(userRepository.save(new User(request)));
    }

    @Transactional
    public ApiForm<?> saveBasket(Long id, Long order_id) {
        Optional<Basket> findBasket = basketRepository.findByUserIdAndOrderId(id, order_id);
        if (findBasket.isPresent()) {
            return failed("중복된 것은 담을 수 없습니다.");
        }
        Basket basket = new Basket();
        userRepository.findById(id).ifPresent((u) -> basket.setUser(u));
        orderListRepository.findById(order_id).ifPresent((order) -> basket.setOrderList(order));
        basketRepository.save(basket);
        return succeed(null, "장바구니 담기 성공.");
    }

    @Transactional
    public ApiForm<?> deleteBasket(Long user_id, Long order_id){
        Optional<Basket> basket = basketRepository.findByUserIdAndOrderId(user_id, order_id);
        if (basket.isPresent()){
            basket.get().setUser(null);
            basket.get().setOrderList(null);
            basketRepository.delete(basket.get());
            return succeed(null, "장바구니 삭제 성공");
        }
        return failed("삭제에 실패했습니다.");
    }

}
