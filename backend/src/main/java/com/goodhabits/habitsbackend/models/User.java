package com.goodhabits.habitsbackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
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

    public User(String _id, String userId, String userName) {
        this._id = _id;
        this.userId = userId;
        this.userName = userName;

    }

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
