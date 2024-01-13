package com.goodhabits.habitsbackend.service;

import com.goodhabits.habitsbackend.entity.Profile;
import com.goodhabits.habitsbackend.exceptions.EntityAlreadyExistsException;
import com.goodhabits.habitsbackend.exceptions.EntityNotFoundException;
import com.goodhabits.habitsbackend.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private ProfileRepository profileRepository;


    @Override
    public Profile getProfile(String id) {
        Optional<Profile> profile = profileRepository.findByUserId(new ObjectId(id));
        return unwrapProfile(profile, id);
    }

    @Override
    public List<Profile> getProfiles() {
        return (List<Profile>) profileRepository.findAll();
    }

    @Override
    public Profile saveProfile(Profile profile) {
        if (!profileRepository.existsByUserName(profile.getUserName())) return profileRepository.save(profile);
        else throw new EntityAlreadyExistsException(Profile.class, profile.getUserName());
    }

    static Profile unwrapProfile(Optional<Profile> entity, String id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Profile.class);
    }
}
