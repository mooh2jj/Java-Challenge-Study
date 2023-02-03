package com.javatechie.springbootcrudexample.controller;

import com.javatechie.springbootcrudexample.entity.User;
import com.javatechie.springbootcrudexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }
    @PostMapping("/addUsers")
    public List<User> saveUsers(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> findUsers() {
        return service.getUsers();
    }
    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable String id) {
        return service.getUserById(id);
    }

//    @GetMapping("/user/{name}")
//    public User findUserByName(@PathVariable String name) {
//        return service.getUserByName(name);
//    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        return service.deleteUser(id);
    }
}
