package com.goodhabits.habitsbackend.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@DisplayName("Tests for Event Entity")
public class EventTest {

    Event event;

    @BeforeEach
    void beforeEachTestMethod() {
        event = new Event();
    }

    @DisplayName("Creates a valid Event")
    @Test
    void testEventEntity_WhenGivenValidDetails_ShouldCreateEvent() {

        // Arrange
        String id = "123";
        String name = "Running";
        int minutes = 52;
        float distance = 3.2f;
        LocalDate date = LocalDate.parse("2023-12-13");

        // Act
        event.set_id(id);
        event.setName(name);
        event.setMinutes(minutes);
        event.setDistance(distance);
        event.setDate(date);

        // Assert
        assertEquals(id, event.get_id(), "Returned an _id that was not expected");
        assertEquals(name, event.getName(), "Returned a name that was not expected");
        assertEquals(minutes, event.getMinutes(), "Returned minutes that was not expected");
        assertEquals(distance, event.getDistance(), "Returned a distance that was not expected");
        assertEquals(date, event.getDate(), "Returned a date that was not expected");

    }

    @DisplayName("Creates another valid Event")
    @Test
    void testEventEntity_WhenGivenOtherValidDetails_ShouldCreateAnotherEvent() {

        // Arrange
        String id = "123";
        String name = "Running";
        int minutes = 52;
        float distance = 3.2f;
        LocalDate date = LocalDate.parse("2023-12-13");

        // Act
        Event newEvent = new Event(name, minutes, distance, date);

        // Assert
        assertEquals(name, newEvent.getName(), "Returned a name that was not expected");
        assertEquals(minutes, newEvent.getMinutes(), "Returned minutes that was not expected");
        assertEquals(distance, newEvent.getDistance(), "Returned a distance that was not expected");
        assertEquals(date, newEvent.getDate(), "Returned a date that was not expected");
        assertNull(newEvent.get_id(), "Returned an id that was not null");

    }
}
