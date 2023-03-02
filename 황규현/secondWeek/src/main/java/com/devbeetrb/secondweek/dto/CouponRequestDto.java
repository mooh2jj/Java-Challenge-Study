package com.devbeetrb.secondweek.dto;

import com.devbeetrb.secondweek.persistence.CouponStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CouponRequestDto {
    private Long id;
    private Long userId;
    private String code;
    private Long discountValue;

    private CouponStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiredAt;
}
