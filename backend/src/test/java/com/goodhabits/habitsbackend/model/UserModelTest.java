package com.goodhabits.habitsbackend.model;

import com.goodhabits.habitsbackend.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserModelTest {

    User user;

    String _id;
    String userId;
    String userName;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Create a new user using the User model")
    void userModel_whenGivenCorrectArguments_ShouldReturnAUserInstance() {

       // Arrange
        _id = "123ABC";
        userId = "456DEF";
        userName = "Test";

        // Act
        user = new User(_id, userId, userName);

        // Assert
        assertEquals(user.get_id(), _id, "Expected _id is different");
        assertEquals(user.getUserId(), userId, "Expected userId is different");
        assertEquals(user.getUserName(), userName, "Expected userName is different");
    }

    @Test
    @DisplayName("Create a second user using User model ")
    void userModel_whenGivenCorrectArguments_ShouldReturnAnotherUser() {

        // Arrange
        _id = "789DDD";
        userId = "ABC123";
        userName = "AnotherTest";

        // Act
        user = new User(_id, userId, userName);

        // Assert
        assertEquals(user.get_id(), _id, "Expected _id is different");
        assertEquals(user.getUserId(), userId, "Expected userId is different");
        assertEquals(user.getUserName(), userName, "Expected userName is different");
    }


}
