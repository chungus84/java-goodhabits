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

    @DisplayName("Creates another habit entitiy")
    @Test
    void testHabitEntity_WHenGivenOtherValidDetails_ShouldAlsoCreateAHabit() {

        // Arrange
        String habitName = "Running";
        String habitType = "cardio";
        LocalDate date = LocalDate.parse("2023-11-15");

        // Act
        Habit newHabit = new Habit(habitName, habitType, date);

        // Assert
        assertEquals(habitName, newHabit.getName(), "Returned a habit name that was not expected");
        assertEquals(habitType, newHabit.getType(), "Returned a habit type that was not expected");
        assertEquals(date, newHabit.getCreatedAt(), "Returned a date that was not expected");
        assertNull(newHabit.get_id(), "Returned _id was not null");
        assertNull(newHabit.getEvents(), "Returned events was not null");

    }

}
