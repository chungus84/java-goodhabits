package com.goodhabits.habitsbackend.service;

import com.goodhabits.habitsbackend.entity.Profile;

import java.util.List;

public interface ProfileService {

    Profile getProfile(String id);

    List<Profile> getProfiles();

    Profile saveProfile(Profile profile);

}
