package com.GrowSkil.service;

import java.util.List;

import com.GrowSkil.entity.User;
import com.GrowSkil.exception.UserNotFoundException;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id) throws UserNotFoundException;
    User saveUser(User user);
    void deleteUser(int id) throws UserNotFoundException;
}
