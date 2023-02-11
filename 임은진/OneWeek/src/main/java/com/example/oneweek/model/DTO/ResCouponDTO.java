package com.example.oneweek.model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResCouponDTO {

    private String cupon_nm; // 쿠폰명
    private String status; // 사용가능 상태
}
