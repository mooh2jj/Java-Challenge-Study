package com.example.hellorest.controller;

import com.example.hellorest.dto.Coopon;
import com.example.hellorest.service.CooponService;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

@RestController
public class CooponController {

    CooponService cooponService;

    public CooponController(CooponService cooponService) {
        this.cooponService = cooponService;
    }

    @PostMapping("/cooponNameCheck")
    ResponseEntity<?> nameCheck(@RequestBody Coopon coopon){
//
        return new ResponseEntity<>(cooponService.nameCheck(Coopon.builder().name(coopon.getName()).build()),
                HttpStatus.OK);
    }

    @PostMapping("/cooponCheck")
    ResponseEntity<?> cooponCheck(@RequestBody Coopon coopon){


        return new ResponseEntity<>(cooponService.cooponCheck(coopon),
        HttpStatus.OK);
    }


}
