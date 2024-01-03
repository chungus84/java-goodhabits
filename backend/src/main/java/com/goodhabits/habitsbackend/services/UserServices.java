package com.goodhabits.habitsbackend.services;


import com.goodhabits.habitsbackend.models.User;
import com.goodhabits.habitsbackend.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getByUser(String userId) {
        System.out.println(userId);
//        ObjectId newId = new ObjectId(userId);
//        System.out.println(newId);
        return userRepository.getByUserId(new ObjectId(userId));
    }
}
