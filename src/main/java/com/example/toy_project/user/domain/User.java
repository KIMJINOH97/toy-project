package com.example.toy_project.user.domain;

import com.example.toy_project.basket.domain.Basket;
import com.example.toy_project.user.application.UserPostRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
//
//    @OneToMany(mappedBy = "user")
//    private List<Basket> orderLists;

    public User(UserPostRequest request){
        this.name = request.getName();
    }

    public User(String name){
        this.name = name;
    }
}
