package com.goodhabits.habitsbackend.repository;

import com.goodhabits.habitsbackend.entity.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<Profile, String> {

    Optional<Profile> findByUserId(Object userId);

//    @ExistsQuery("profile.userName": )
    boolean existsByUserName(String userName);



}
