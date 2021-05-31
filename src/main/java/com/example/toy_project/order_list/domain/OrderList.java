package com.example.toy_project.order_list.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "order_list")
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    private String name;

//    @Lob
//    private byte[] picture;

    private Integer price;
    private Integer count;
    private String url;

    public OrderList(String name, Integer price, Integer count, Long pid){
        this.name = name;
        this.price = price;
        this.count = count;
        String fileUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/files/")
                .path(String.valueOf(pid))
                .toUriString();

        this.url = fileUrl;
    }

    public OrderList(String name, Integer price, Integer count){
        this.name = name;
        this.price = price;
        this.count = count;
    }
}
