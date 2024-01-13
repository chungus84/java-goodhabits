package com.goodhabits.habitsbackend.service;

import com.goodhabits.habitsbackend.entity.Profile;
import com.goodhabits.habitsbackend.exceptions.EntityAlreadyExistsException;
import com.goodhabits.habitsbackend.exceptions.EntityNotFoundException;
import com.goodhabits.habitsbackend.repository.ProfileRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing.*;

import java.time.LocalDate;
import java.util.IllegalFormatException;
import java.util.Optional;
import java.util.UUID;
import java.util.jar.JarOutputStream;

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

    @DisplayName("saveProfile with blank details")
    @Test
    void testSaveProfile_WhenProvidedWithBlankDetails_ShouldNotCreateProfile() {
        Profile invalidProfile = new Profile();

        when(profileRepository.save(any(Profile.class))).thenThrow(IllegalArgumentException.class);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()-> {
            profileService.saveProfile(invalidProfile);
        });

        verify(profileRepository, times(1)).save(invalidProfile);

    }

    @DisplayName("Throws Exception if userName already exists")
    @Test
    void testSaveProfile_WHenProvidedUserNameAlreadyExists_ShouldThrowsEntityAlreadyExistsException() {
        // Act
        String duplicateUserName = "Test";
        String newUserId = "456";
        LocalDate date = LocalDate.parse("2023-11-11");
        Profile dupeProfile = new Profile(newUserId, duplicateUserName, date);
        String exceptionMessage = "The profile with value Test already exists in our records";

        when(profileRepository.existsByUserName(dupeProfile.getUserName())).thenReturn(true);

        EntityAlreadyExistsException thrown = assertThrows(EntityAlreadyExistsException.class, ()-> {
            profileService.saveProfile(dupeProfile);
        }, "Should have thrown a Entity Already exists exception");

        System.out.println(thrown.getMessage());

        verify(profileRepository, times(1)).existsByUserName(dupeProfile.getUserName());
        assertEquals(exceptionMessage, thrown.getMessage(), "Exception message was not as expected");
    }

    @DisplayName("Should getProfile")
    @Test
    void testGetProfile_WhenGivenAValidProfileId_ShouldReturnAProfile() {

        // Act
        Profile profile = new Profile(userId, userName, date);

        when(profileRepository.findByUserId(profile.getUserId())).thenReturn(Optional.of(profile));

        Profile storedProfile = profileService.getProfile(userId);

        assertEquals(profile.getUserId(), storedProfile.getUserId(), "Returned userId was different from expected");
    }

    @DisplayName("Should not return a profile")
    @Test
    void testUnwrapProfile_WhenGivenAnIdThatDoesNotExist_ShouldReturnEntityNotFoundException() {
        // Arrange
        Profile profile = new Profile(userId, userName, date);
        String badUserId = "456";
        String expectedExceptionMessage = "The profile with id 456 does not exist in our records";

        // Act
//        when(profileRepository.findByUserId(badUserId)).thenCallRealMethod();

        EntityNotFoundException thrown = assertThrows(EntityNotFoundException.class, ()-> {
            ProfileServiceImpl.unwrapProfile(Optional.empty(), badUserId);
        }, "Should have thrown EntityNotFound Exception");

        assertEquals(expectedExceptionMessage, thrown.getMessage(), "Exception message was not as expected");
    }





}
