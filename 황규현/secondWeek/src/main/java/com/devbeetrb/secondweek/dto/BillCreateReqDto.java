package com.devbeetrb.secondweek.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BillCreateReqDto {
    private String itemName;
    private Long payPrice;
    private List<OrderCreateReqDto> orderCreateReqDto;

    public BillCreateReqDto(String itemName, Long payPrice) {
        this.itemName = itemName;
        this.payPrice = payPrice;
    }
}
