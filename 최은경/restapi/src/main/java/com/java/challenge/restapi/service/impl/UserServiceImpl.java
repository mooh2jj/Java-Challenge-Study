package com.java.challenge.restapi.service.impl;

import com.java.challenge.restapi.entity.User;
import com.java.challenge.restapi.repository.UserRepository;
import com.java.challenge.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public String deleteUser(int id) {
        repository.deleteById(id);
        return "user removed !! " + id;
    }

    @Override
    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        return repository.save(existingUser);
    }
}
