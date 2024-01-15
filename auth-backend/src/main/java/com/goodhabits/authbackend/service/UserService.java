package com.goodhabits.authbackend.service;

import com.goodhabits.authbackend.entity.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    List<User> getUsers();

    User getUserByUserName(String userName);

    User saveUser(User user);
}
