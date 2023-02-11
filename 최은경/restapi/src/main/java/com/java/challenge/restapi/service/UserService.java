package com.java.challenge.restapi.service;

import com.java.challenge.restapi.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> saveUsers(List<User> users);
    List<User> getUsers();
    User getUserById(int id);
    User getUserByName(String name);
    String deleteUser(int id);
    User updateUser(User user);
}
