package com.java.challenge.restapi.controller;

import com.java.challenge.restapi.entity.User;
import com.java.challenge.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        return service.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }
    @GetMapping("/userById/{id}")
    public User findUserById(@PathVariable int id){
        return service.getUserById(id);
    }
    @GetMapping("/user/{name}")
    public User findUserByName(@PathVariable String name){
        return service.getUserByName(name);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }
}
