package com.example.oneweek.model.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ReqCouponDTO {

    private Integer idx_coupon;
    private String coupon_nm; // 쿠폰명
    private Date beginDt; // 시작일자
    private Date endDt; // 종료일자

}
