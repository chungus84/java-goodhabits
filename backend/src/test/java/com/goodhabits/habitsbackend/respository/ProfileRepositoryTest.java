package com.goodhabits.habitsbackend.respository;

import com.goodhabits.habitsbackend.entity.Profile;
import com.goodhabits.habitsbackend.repository.ProfileRepository;
import org.junit.jupiter.api.*;
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
        Optional<Profile> storedProfile = profileRepository.findByUserId(userId);

        // Arrange
        assertFalse(storedProfile.isPresent(), "Should not return a Profile");
    }

    @DisplayName("Creates a new Profile")
    @Test
    void testCreateProfile_WhenGivenValidDetails_ShouldCreateANewProfile() {

        // Arrange
        Profile newProfile = new Profile(UUID.randomUUID().toString(), "NewUser", LocalDate.parse("2023-12-02"));

        // Act
        profileRepository.save(newProfile);
        Optional<Profile> storedProfile = profileRepository.findByUserId(newProfile.getUserId());

        // Assert
        assertEquals(newProfile.getUserId(), storedProfile.get().getUserId(), "Returned UserId that was not expected");
        assertEquals(newProfile.getUserName(), storedProfile.get().getUserName(), "Returned UserName was not as expected");
        assertEquals(newProfile.getCreatedAt(), storedProfile.get().getCreatedAt(), "Returned CreatedAt date was not as expected");
        assertNull(storedProfile.get().getHabits(), "Returned habits should be null");
        assertNotNull(storedProfile.get().get_id(), "Returned _id should not be null");

    }

    @DisplayName("Testing to see if a userName already exists")
    @Test
    void testExistsByUserName_WhenGivenAUserNameThatExists_ShouldReturnTrue() {

        // Arrange
        Profile dupeProfile = new Profile("456", "Test", LocalDate.parse("2023-11-11"));

        // Act
        boolean result = profileRepository.existsByUserName(dupeProfile.getUserName());

        // Assert
        assertTrue(result, "Expected userNAme does not exist in the database");
    }

    @DisplayName("Testing to see if a userName does not exist")
    @Test
    void testExistByUserName_WHenGivenAUserNameThatDoesNotExist_ShouldReturnFalse() {

        // Arrange
        Profile newProfile = new Profile("456","Testy", LocalDate.parse("2023-11-11"));

        // Act
        boolean result = profileRepository.existsByUserName(newProfile.getUserName());

        // Arrange
        assertFalse(result, "Should have returned false");
    }

}
