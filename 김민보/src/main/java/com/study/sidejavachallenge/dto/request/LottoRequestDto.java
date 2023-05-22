package com.study.sidejavachallenge.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LottoRequestDto {

    private int num;

    @Builder
    public LottoRequestDto(int num) {
        this.num = num;
    }
}
