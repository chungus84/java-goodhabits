package com.goodhabits.habitsbackend.service;

import com.goodhabits.habitsbackend.entity.Profile;
import com.goodhabits.habitsbackend.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing.*;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Profile Service Tests")
public class ProfileServiceTest {

    @InjectMocks
    ProfileServiceImpl profileService;

    @Mock
    ProfileRepository profileRepository;



    String _id;
    String userName;
    String userId;
    LocalDate date;



    @BeforeEach
    void setup() {
        userName = "Test";
        userId = "123";
        date = LocalDate.parse("2023-12-12");



    }

    @DisplayName("Profile created")
    @Test
    void testSaveProfile_WhenProfileDetailsProvided_ShouldReturnUserObject() {
        Profile newProfile = new Profile(userId, userName, date);

        when(profileRepository.save(any(Profile.class))).thenReturn(newProfile);


        Profile profile = profileService.saveProfile(newProfile);


        assertNotNull(profile, "The saveProfile should not have returned null");
        assertEquals(userName, profile.getUserName(), "UserName did not return as expected");
        assertEquals(userId, profile.getUserId(), "UserId did not return as expected");
        assertEquals(date, profile.getCreatedAt(), "CreatedAt date did not return as expected");
        verify(profileRepository, times(1)).save(newProfile);


    }

}
