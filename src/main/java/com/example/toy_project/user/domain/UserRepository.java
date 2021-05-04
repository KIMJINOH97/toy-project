package com.example.toy_project.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select U from User U where U.name = ?1")
    Optional<User> findByName(String name);

}
