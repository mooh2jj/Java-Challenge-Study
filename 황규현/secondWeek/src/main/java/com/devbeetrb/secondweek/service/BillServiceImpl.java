package com.devbeetrb.secondweek.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillServiceImpl {
    private final CouponServiceImpl couponService;
}
