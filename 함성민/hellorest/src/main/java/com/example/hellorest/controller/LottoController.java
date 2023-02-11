package com.example.hellorest.controller;

import com.example.hellorest.dto.Info;
import com.example.hellorest.dto.Lotto;
import com.example.hellorest.service.LottoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class LottoController {

    LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @PostMapping("/lotto")
    ResponseEntity<?> lootoPlay(@RequestBody Lotto lotto){
        System.out.println("Lotto Controller init");
        return new ResponseEntity<>(lottoService.playLotto(lotto), HttpStatus.OK);
    }

}
