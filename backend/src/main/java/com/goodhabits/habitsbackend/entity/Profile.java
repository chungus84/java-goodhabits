package com.goodhabits.habitsbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document(collection="profiles")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("userId")
    @NotEmpty(message = "There must be a userId")
    @NonNull
    private String userId;

    @JsonProperty("userName")
    @NotEmpty(message =  "There must be a userName")
    @NonNull
    private String userName;

    @JsonProperty("createdAt")
    private LocalDate createdAt;

    @JsonProperty("habits")
    private List<Habit> habits;

}
