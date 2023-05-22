package com.study.sidejavachallenge.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LottoResponseDto {

    private int num;

    @Builder
    public LottoResponseDto(int num) {
        this.num = num;
    }
}
