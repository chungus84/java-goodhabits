package com.goodhabits.habitsbackend.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@DisplayName("Tests for the Habit Model")
public class HabitTest {

    Habit habit;

    @BeforeEach
    void beforeEachTestMethod() {
        habit = new Habit();
    }

    @DisplayName("Creates a Habit entity")
    @Test
    void testHabitEntity_WhenGivenValidDetails_ShouldCreateAHabit() {

        // Arrange
        String habitName = "Running";
        String habitType = "cardio";
        LocalDate date = LocalDate.parse("2023-11-15");

        // Act
        habit.setName(habitName);
        habit.setType(habitType);
        habit.setCreatedAt(date);

        // Arrange
        assertEquals(habitName, habit.getName(), "Returned a habit name that was not expected");
        assertEquals(habitType, habit.getType(), "Returned habit type that was not expected");
        assertEquals(date, habit.getCreatedAt(), "Returned date that was not expected");
        assertNull(habit.get_id(), "Returned _id was not null");
        assertNull(habit.getEvents(), "Returned events was not null");

    }

}
