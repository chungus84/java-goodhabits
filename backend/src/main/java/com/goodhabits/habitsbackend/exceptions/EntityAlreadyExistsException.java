package com.goodhabits.habitsbackend.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(Class<?> entity, String value) {
        super("The " + entity.getSimpleName().toLowerCase() + " with value " + value + " already exists in our records");
    }
}
