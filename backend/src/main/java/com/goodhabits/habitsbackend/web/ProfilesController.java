package com.goodhabits.habitsbackend.web;

import com.goodhabits.habitsbackend.entity.Profile;
import com.goodhabits.habitsbackend.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/profiles")
public class ProfilesController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/{userId}")
    public ResponseEntity<Profile> getProfile(@PathVariable String userId) {
        return new ResponseEntity<>(profileService.getProfile(userId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getProfiles() {
        return new ResponseEntity<>(profileService.getProfiles(),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Profile> addProfile(@Valid @RequestBody Profile profile) {
        Profile savedProfile = profileService.saveProfile(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }


}
