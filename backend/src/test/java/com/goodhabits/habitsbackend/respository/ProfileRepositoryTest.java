package com.goodhabits.habitsbackend.respository;

import com.goodhabits.habitsbackend.entity.Profile;
import com.goodhabits.habitsbackend.repository.ProfileRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.swing.text.html.Option;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


@DisplayName("Profile Repository Tests")
@DataMongoTest
public class ProfileRepositoryTest {



    @Autowired
    ProfileRepository profileRepository;

    private Profile profile1;
    private Profile profile2;

    @BeforeEach
    void setUp() {
        profile1 = new Profile();
        profile1.set_id(UUID.randomUUID().toString());
        profile1.setUserId("123");
        profile1.setUserName("Test");
        profile1.setCreatedAt(LocalDate.parse("2023-11-15"));
        profileRepository.save(profile1);

        profile2 = new Profile("345", "AnotherTest", LocalDate.parse("2023-12-01"));
        profile2.set_id(UUID.randomUUID().toString());
        profileRepository.save(profile2);
    }

    @AfterEach
    void tearDown() {
        profileRepository.deleteAll();
    }

    @DisplayName("Should return the correct user when given a Valid userId")
    @Test
    void testFindByUserId_WhenGivenCorrectUserId_ShouldReturnAProfileEntity() {
        // Arrange

        String userId = "123";

        // Act
        Optional<Profile> storedProfile = profileRepository.findByUserId(userId);

        // Assert
        assertEquals(userId, storedProfile.get().getUserId(), "Returned userId is not what was expected");
        assertEquals("Test", storedProfile.get().getUserName(), "Returned UserName was not as expected");
        assertEquals(LocalDate.parse("2023-11-15"), storedProfile.get().getCreatedAt(), "Returned CreatedAt date was not as expected");
        assertNull(storedProfile.get().getHabits(), "Habits are not null");

    }

    @DisplayName("Should return AnotherTest profile")
    @Test
    void testFindByUserId_WhenGivenAnotherCorrectUserId_ShouldReturnAnotherProfile() {
        //  Arrange

        String userId = "345";

        // Act
        Optional<Profile> storedProfile = profileRepository.findByUserId(userId);

        // Assert
        assertEquals(userId, storedProfile.get().getUserId(), "Returned userId is not what was expected");
        assertEquals("AnotherTest", storedProfile.get().getUserName(), "Returned UserName was not as expected");
        assertEquals(LocalDate.parse("2023-12-01"), storedProfile.get().getCreatedAt(), "Returned CreatedAt date was not as expected");
        assertNull(storedProfile.get().getHabits(), "Habits are not null");
        assertNotNull(storedProfile.get().get_id(), "Profile _id should not be null");
    }
    
    @DisplayName("Should not return a user if userId is not valid")
    @Test
    void testFindByUserId_WhenGivenAnIdThatDoesNotExist_ShouldNotReturnAProfile() {
        // Arrange
        String userId = "555";

        // Act
        Optional<Profile> storedPorfile = profileRepository.findByUserId(userId);

        // Arrange

    }

}
