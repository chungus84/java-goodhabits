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



}
