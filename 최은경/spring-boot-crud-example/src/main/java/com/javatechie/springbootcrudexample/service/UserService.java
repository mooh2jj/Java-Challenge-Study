package com.javatechie.springbootcrudexample.service;

import com.javatechie.springbootcrudexample.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> saveUsers(List<User> users);

    List<User> getUsers();
    User getUserById(String id);

//    User getUserByName(String name);

    String deleteUser(String id);

    User updateUser(User user);
}
