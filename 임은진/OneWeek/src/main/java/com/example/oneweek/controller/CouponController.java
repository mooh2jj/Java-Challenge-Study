package com.example.oneweek.controller;

import com.example.oneweek.mapper.CouponMapper;
import com.example.oneweek.model.DTO.ReqCouponDTO;
import com.example.oneweek.model.DTO.ResCouponDTO;
import com.example.oneweek.model.DTO.couponStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
public class CouponController {

    public final String REGEX = "^[가-힣~!@#$%^&*()_+|<>?:{} ]*$";
    public final CouponMapper couponMapper;

    couponStatus CouponStatus;

    @PostMapping("/getCouponInfo")
    public ResCouponDTO getCouponInfo(@RequestBody ReqCouponDTO rq){

        ReqCouponDTO info = couponMapper.getCouponInfoByName(rq.getCoupon_nm());

        if(info!=null){
            if(!Pattern.matches(REGEX, info.getCoupon_nm())){
                return ResCouponDTO.builder()
                        .cupon_nm(rq.getCoupon_nm())
                        .status(CouponStatus.MISMATCH.str)
                        .build();
            }
            Boolean statusCheck = statusCheck(info);

            return ResCouponDTO.builder()
                    .cupon_nm(rq.getCoupon_nm())
                    .status(statusCheck? CouponStatus.SUCCESS.str : CouponStatus.UNAVAILABLE.str)
                    .build();
        }
        return ResCouponDTO.builder()
                .cupon_nm("")
                .status(CouponStatus.NONEXISTENCE.str)
                .build();
    }

    private Boolean statusCheck(ReqCouponDTO info) {
        Boolean status = false;
        Date today = new Date();
        if(today.before(info.getEndDt()) && today.after(info.getBeginDt())){
            status = true;
        }
        return status;
    }
}
