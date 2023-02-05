package com.example.oneweek.mapper;

import com.example.oneweek.model.DTO.ReqCouponDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {
    public ReqCouponDTO getCouponInfoByName(String coupon_nm);
}
