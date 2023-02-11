package com.example.hellorest.controller;

import com.example.hellorest.dto.Info;
import com.example.hellorest.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestFullController {

    TestService testService;

    public RestFullController(TestService testService) {
        this.testService = testService;
    }

    //    @GetMapping("/get")
//    public String test(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
//        if(name != null & age==null){
//            return "나의 이름은 " + name + " 입니다.";
//        }else if (name == null & age != null){
//            return "나는 "+age+"살 입니다.";
//        }else if (name != null & age != null){
//            return "나의 이름은 " + name + "이며 " + age + "살 입니다.";
//        }else
//            return "나는 이름도 나이도 없습니다.";
//    }
//
//    @PostMapping("/post")
//    public String test(@RequestBody String name){
//        return "내 이름은 "+name+"입니다.";
//    }

    @GetMapping("/get")
    ResponseEntity<?> getTest(@RequestParam(required = false) String name){

        return new ResponseEntity<>(testService.myName(name), HttpStatus.OK);
    }

    @PostMapping("/post/{age}")
    ResponseEntity<?> postTest(@PathVariable("age") Integer age){

        return new ResponseEntity<>(testService.myAge(age), HttpStatus.OK);
    }

    @PostMapping("/info")
    ResponseEntity<?> bodyTest(@RequestBody Info info){
        return new ResponseEntity<>(testService.myInfo(info), HttpStatus.OK);
    }

}
