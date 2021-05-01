package com.example.toy_project.user.service;

import com.example.toy_project.user.application.UserPostRequest;
import com.example.toy_project.user.application.UserPostResponse;
import com.example.toy_project.user.domain.User;
import com.example.toy_project.user.domain.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserPostResponse save(UserPostRequest request){
        Optional<User> findUser = userRepository.findByName(request.getName());
        System.out.println(findUser);
        if (findUser == null) {
            // 찾는 User가 없으면 새로 만들어 줌
            return new UserPostResponse(userRepository.save(new User(request)));
        }
        return new UserPostResponse(findUser.get());
    }

}
