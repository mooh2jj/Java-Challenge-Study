package com.java.coupon.dto;

import com.java.coupon.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponReqDto {
    private int cpId;
    private String cpName;
    private String cpCode;
    private String userId;
    private char usageStatus;
    private char status;
    private LocalDateTime beginDt;
    private LocalDateTime endDt;

    public Coupon toEntity(){
        return Coupon.builder()
                .cpId(this.cpId)
                .cpName(this.cpName)
                .cpCode(this.cpCode)
                .userId(this.userId)
                .usageStatus(this.usageStatus)
                .status(this.status)
                .beginDt(this.beginDt)
                .endDt(this.endDt)
                .build();
    }
}
