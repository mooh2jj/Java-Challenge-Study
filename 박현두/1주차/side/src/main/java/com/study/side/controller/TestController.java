package com.study.side.controller;

import com.study.side.dto.LoginDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }


    @PostMapping(value = "/loginByJson", consumes = "application/json", produces = "application/json")
    public LoginDTO loginByJson(@RequestBody LoginDTO loginDTO) {
        return loginDTO;
    }

    @PostMapping(value = "/loginByForm", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    public LoginDTO loginByForm(@ModelAttribute LoginDTO loginDTO) {
        return loginDTO;
    }

    @PostMapping("/lotto")
    public String lotto(@RequestParam("lotto") String lotto) {
        return lotto;
    }
}
