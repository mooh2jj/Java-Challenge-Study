package com.javatechie.springbootcrudexample.repository;

import com.javatechie.springbootcrudexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

//    User findByName(String name);

}
