package com.example.toy_project.user.service;

import com.example.toy_project.user.application.UserPostRequest;
import com.example.toy_project.user.domain.User;
import com.example.toy_project.user.domain.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;

    @AfterEach
    public void delete(){
        userRepository.deleteAll();
    }

    @Test
    public void save(){
        //given
        String name1 = "name1";
        String name2 = "name2";

        UserPostRequest request = new UserPostRequest(name1);
        UserPostRequest request2 = new UserPostRequest(name2);
        //when
        userService.save(request);
        userService.save(request2);

        //then
        List<User> all = userRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

    }
}