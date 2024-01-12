package com.goodhabits.habitsbackend.service;

import com.goodhabits.habitsbackend.entity.Profile;

public interface ProfileService {

    Profile getProfile(String id);

    Profile saveProfile(Profile profile);

}
