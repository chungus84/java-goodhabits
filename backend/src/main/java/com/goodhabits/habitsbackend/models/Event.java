package com.goodhabits.habitsbackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "events")
public class Event {

    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("name")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @JsonProperty("minutes")
    @NotEmpty(message = "Minutes must not be empty")
    private int minutes;

    @JsonProperty("distance")
    @NotEmpty(message = "Distance must not be empty")
    private float distance;

    @JsonProperty("date")
    private Date date;


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

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
