package com.goodhabits.habitsbackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Habit {

    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("name")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @JsonProperty("type")
    @NotEmpty(message = "Type must not be empty")
    private String type;

    @JsonProperty("events")
    private List<ObjectId> events;

    @JsonProperty("createdAt")
    private Date createdAt;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ObjectId> getEvents() {
        return events;
    }

    public void setEvents(List<ObjectId> events) {
        this.events = events;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
