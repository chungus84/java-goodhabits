package com.goodhabits.authbackend.repository;

import com.goodhabits.authbackend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByUserName(String userName);

    Optional<User> findByUserName(String userName);
}
