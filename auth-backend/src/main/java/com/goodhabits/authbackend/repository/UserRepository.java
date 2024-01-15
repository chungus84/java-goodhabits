package com.goodhabits.authbackend.repository;

import com.goodhabits.authbackend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByUserName(String userName);
}
