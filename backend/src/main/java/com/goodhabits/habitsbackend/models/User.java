package com.goodhabits.habitsbackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection="users")
public class User {

    @Id
    @JsonProperty("_id")
    private String _id;


    @JsonProperty("userId")
    @NotEmpty(message = "There must be a userId")
    private String userId;

    @JsonProperty("userName")
    @NotEmpty(message =  "There must be a userName")
    private String userName;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("habits")
    private List<Object> habits;

    public List<Object> getHabits() {
        return habits;
    }

    public void setHabits(List<Object> habits) {
        this.habits = habits;
    }
//    public User(String _id, String userId, String userName) {
//        this._id = _id;
//        this.userId = userId;
//        this.userName = userName;
//
//    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
