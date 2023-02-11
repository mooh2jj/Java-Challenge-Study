package com.java.coupon.controller;


import com.java.coupon.dto.CouponReqDto;
import com.java.coupon.dto.CouponRespDto;
import com.java.coupon.entity.Coupon;
import com.java.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponController {
    private final CouponService service;

    @GetMapping("/coupons")
    public List<CouponRespDto> getCoupons(){
        List<CouponRespDto> result = new ArrayList<>();

        List<Coupon> couponList = service.getCoupons();
        for(Coupon coupon : couponList){
            Coupon updatedCoupon = service.updateStatus(coupon);
            result.add(CouponRespDto.builder()
                    .cpName(updatedCoupon.getCpName())
                    .status(updatedCoupon.getStatus())
                    .build());
        }

        return result;
    }

    @PostMapping("/coupon")
    public CouponRespDto addCoupon(@RequestBody CouponReqDto dto){
        Coupon coupon = service.addCoupon(dto);
        return CouponRespDto.builder()
                .cpName(coupon.getCpName())
                .status(coupon.getStatus())
                .build();
    }

    @PostMapping("/coupons")
    public List<CouponRespDto> addCoupons(@RequestBody List<CouponReqDto> dtoList){
        List<CouponRespDto> result = new ArrayList<>();

        for(Coupon coupon : service.addCoupons(dtoList)){
            result.add(CouponRespDto.builder()
                    .cpName(coupon.getCpName())
                    .status(coupon.getStatus())
                    .build());
        }

        return result;
    }
}
