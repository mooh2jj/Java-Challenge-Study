package com.java.coupon.service;

import com.java.coupon.dto.CouponReqDto;
import com.java.coupon.entity.Coupon;

import java.util.List;


public interface CouponService {
    List<Coupon> getCoupons();
    Coupon updateStatus(Coupon coupon);

    Coupon addCoupon(CouponReqDto coupon);
    List<Coupon> addCoupons(List<CouponReqDto> coupons);
}
