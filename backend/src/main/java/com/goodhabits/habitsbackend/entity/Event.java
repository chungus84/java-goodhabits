package com.goodhabits.habitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Document(collection = "events")
public class Event {

    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("name")
    @NotEmpty(message = "Name must not be empty")
    @NonNull
    private String name;

    @JsonProperty("minutes")
    @NotEmpty(message = "Minutes must not be empty")
    @NonNull
    private int minutes;

    @JsonProperty("distance")
    @NotEmpty(message = "Distance must not be empty")
    @NonNull
    private float distance;

    @JsonProperty("date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


}
