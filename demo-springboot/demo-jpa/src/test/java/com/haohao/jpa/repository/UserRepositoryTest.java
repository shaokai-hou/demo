package com.haohao.jpa.repository;

import com.haohao.jpa.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void list() {
        userRepository.findAll().forEach(System.err::println);
    }

    @Test
    void insert(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
        userEntity.setPassword("admin");
        userRepository.save(userEntity);
    }
}