package com.example.jpatest.services;

import com.example.jpatest.models.User;
import com.example.jpatest.models.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}