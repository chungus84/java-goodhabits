package com.goodhabits.authbackend.service;

import com.goodhabits.authbackend.entity.User;

public interface UserService {

    User getUser(String id);

    User saveUser(User user);
}
