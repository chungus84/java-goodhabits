package com.goodhabits.habitsbackend.repositories;

import com.goodhabits.habitsbackend.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRepository extends MongoRepository <User, String > {

    User getByUserId(Object userId);


}
