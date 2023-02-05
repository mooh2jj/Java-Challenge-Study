package com.example.oneweek.model.DTO;

public enum couponStatus {
    SUCCESS("사용 가능"),
    UNAVAILABLE("사용불가 : 현재 해당되지 않는 기간의 쿠폰입니다"),
    MISMATCH("사용불가 : 형식이 일치하지 않는 쿠폰입니다"),
    NONEXISTENCE("사용불가 : 존재하지 않는 쿠폰입니다");

    public String str;
    couponStatus(String str){
        this.str = str;
    }
}
