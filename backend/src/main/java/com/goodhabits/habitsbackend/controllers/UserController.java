package com.goodhabits.habitsbackend.controllers;


import com.goodhabits.habitsbackend.models.User;
import com.goodhabits.habitsbackend.services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {this.userServices = userServices;}

//    @GetMapping(value="/habit")
//    public List<User> getAllUsers() {return userServices.getAllUsers();}
    @GetMapping(value="/habit")
    public User getUserById(@RequestHeader("userid") String userId) {
//        System.out.println(new ObjectId(userId));
        return userServices.getByUser(userId);
    }
}
