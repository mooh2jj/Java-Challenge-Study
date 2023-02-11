package com.example.hellorest.service;

import com.example.hellorest.dto.Info;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String myName(String name){
        if (name != null){
            return "my name is " + name;
        }else {
            return "no name";
        }
    }
    public String myAge(Integer age){
        if (age != null){
            return "my age is " + age;
        }else {
            return "no age";
        }
    }

    public String myInfo(Info info){
        return myName(info.getName()) + " / " + myAge(info.getAge());
    }

}
