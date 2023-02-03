package com.javatechie.springbootcrudexample.service.impl;

import com.javatechie.springbootcrudexample.entity.User;
import com.javatechie.springbootcrudexample.repository.UserRepository;
import com.javatechie.springbootcrudexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }
    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public List<User> getUsers() {
        return  repository.findAll();
    }
    public User getUserById(String id) {
        return  repository.findById(id).orElse(null);
    }

//    public User getUserByName(String name) {
//        return  repository.findByName(name);
//    }

    public String deleteUser(String id) {
        repository.deleteById(id);
        return "user removed !! " + id;
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(user);
        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        return repository.save(existingUser);
    }
}
