package com.devbeetrb.secondweek.controller;

import com.devbeetrb.secondweek.service.CouponServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponServiceImpl couponService;
    @GetMapping
    public void getCoupon() {
    }
}
