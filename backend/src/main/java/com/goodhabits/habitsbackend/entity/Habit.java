package com.goodhabits.habitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

public class Habit {

    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("name")
    @NotEmpty(message = "Name must not be empty")
    @NonNull
    private String name;

    @JsonProperty("type")
    @NotEmpty(message = "Type must not be empty")
    @NonNull
    private String type;

    @JsonProperty("events")
    @DocumentReference
    private List<Event> events;

    @JsonProperty("createdAt")
    private Date createdAt;


}