package com.goodhabits.authbackend.service;

import com.goodhabits.authbackend.entity.User;
import com.goodhabits.authbackend.exceptions.EntityAlreadyExistsException;
import com.goodhabits.authbackend.exceptions.EntityNotFoundException;
import com.goodhabits.authbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User getUser(String id) {
        Optional<User> user =  userRepository.findById(id);
        return unwrapUser(user, id);
    }

    @Override
    public User saveUser(User user) {
        if (!userRepository.existsByUserName(user.getUserName())) return userRepository.save(user);
        else throw new EntityAlreadyExistsException(User.class, user.getUserName());
    }

    static User unwrapUser(Optional<User> entity, String id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, User.class);
    }
}
