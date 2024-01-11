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
    }
}
