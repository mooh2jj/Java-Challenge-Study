package com.java.coupon.service.impl;

import com.java.coupon.dto.CouponReqDto;
import com.java.coupon.entity.Coupon;
import com.java.coupon.repository.CouponRepository;
import com.java.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponRepository repository;


    @Override
    public List<Coupon> getCoupons() {
        String sb = "[가-힇~!#$%^&*|\\\\\\'\\\";:\\/?]";
        return repository.findAllOnlyKoreanAndExmark(sb);
    }

    @Override
    public Coupon updateStatus(Coupon coupon) {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime start = coupon.getBeginDt();
        LocalDateTime end = coupon.getEndDt();

        if(current.isAfter(start) && current.isBefore(end))
            coupon.setStatus('Y');
        else coupon.setStatus('N');

        return repository.save(coupon);
    }

    @Override
    public Coupon addCoupon(CouponReqDto coupon) {
        return repository.save(Coupon.builder()
                .cpName(coupon.getCpName())
                .cpCode(coupon.getCpCode())
                .userId(coupon.getUserId())
                .usageStatus(coupon.getUsageStatus())
                .status(coupon.getStatus())
                .beginDt(coupon.getBeginDt())
                .endDt(coupon.getEndDt())
                .build());
    }

    @Override
    public List<Coupon> addCoupons(List<CouponReqDto> coupons) {
        List<Coupon> result = new ArrayList<>();

        for(CouponReqDto dto : coupons){
            result.add(repository.save(Coupon.builder()
                    .cpName(dto.getCpName())
                    .cpCode(dto.getCpCode())
                    .userId(dto.getUserId())
                    .usageStatus(dto.getUsageStatus())
                    .status(dto.getStatus())
                    .beginDt(dto.getBeginDt())
                    .endDt(dto.getEndDt())
                    .build()));
        }

        return result;
    }
}
