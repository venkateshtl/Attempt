package com.learning.attemptapi.service;

import com.learning.attemptapi.model.User;
import com.learning.attemptapi.model.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        if(userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new EntityExistsException("email id already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User updateUser(User user) {
        User userFromDb = userRepository.findUserByEmail(user.getEmail()).orElseThrow(() -> new EntityNotFoundException("User with email is not found"));
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        return userRepository.save(userFromDb);
    }

    @Override
    public User getUser(Long user) {
        return null;
    }

    @Override
    public User getUserbyEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
