package com.goodhabits.habitsbackend.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;


@DisplayName("Tests for the Profile Entity")
public class ProfileTest {

    Profile profile;

    @BeforeEach
    void beforeEachTestMethod() {
        profile = new Profile();
    }

    @DisplayName("Creates a valid Profile")
    @Test
    void testProfileModel_WhenGivenValidDetails_ShouldCreateANewProfile() {
        // Arrange
        String id = "123";
        String userId = "ABC123";
        String userName = "Test";
        LocalDate date = LocalDate.parse("2023-11-30");

        // Act
        profile.set_id(id);
        profile.setUserId(userId);
        profile.setUserName(userName);
        profile.setCreatedAt(date);


        // Arrange
        assertEquals(id, profile.get_id(), "Returned _id does not match expected result");
        assertEquals(userId, profile.getUserId(), "Returned userId does not match expected results");
        assertEquals(userName, profile.getUserName(), "Returned UserName does not match expected");
        assertEquals(date, profile.getCreatedAt(), "Returned createdAt date does not match expected");
        assertNull(profile.getHabits(), "Returned habits is not null");
    }

    @DisplayName("Creates another valid Profile")
    @Test
    void testProfileModel_WhenGivenOtherValidDetails_ShouldCreateAnotherProfile() {

        // Arrange
        String userId = "DEF456";
        String userName = "OtherTest";
        LocalDate date = LocalDate.parse("2023-12-15");

        // Act
        Profile secondProfile = new Profile(userId, userName, date);

        // Assert
        assertEquals(userId, secondProfile.getUserId(), "Returned UserId does not match the expected result");
        assertEquals(userName, secondProfile.getUserName(), "Returned UserName does not match the expected result");
        assertEquals(date, secondProfile.getCreatedAt(), "Returned createdAt does not match the expected result");
        assertNull(secondProfile.get_id(), "Returned _id is not Null");
        assertNull(secondProfile.getHabits(), "Returned habits is not null");

    }

}
