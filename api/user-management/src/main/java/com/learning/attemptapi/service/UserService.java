package com.learning.attemptapi.service;

import com.learning.attemptapi.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void removeUser(User user);
    User updateUser(User user);
    User getUser(Long user);
    User getUserbyEmail(String email);
    List<User> getAllUsers();
}
