package com.goodhabits.authbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "users")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("firstName")
    @NotEmpty(message = "There must be a First Name")
    @NotNull
    @NonNull
    private String firstName;

    @JsonProperty("lastName")
    @NotEmpty(message = "There must be a Last Name")
    @NotNull
    @NonNull
    private String lastName;

    @JsonProperty("userName")
    @NotEmpty(message = "There must be a Username")
    @NotNull
    @NonNull
    private String userName;

    @JsonProperty("email")
    @NotEmpty(message = "There must be an email")
    @NotNull
    @NonNull
    @Email
    private String email;

    @JsonProperty("password")
    @NotEmpty(message = "There must be a password")
    @NotNull
    @NonNull
    private String password;

    @JsonProperty("createdAt")
    private LocalDate createdAt = LocalDate.now();




}
